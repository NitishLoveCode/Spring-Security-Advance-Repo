package employee_management_portal.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userts")
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable =  false, unique = true, length = 30)
    private String employeeCode;

    @Column(nullable =  false)
    private String fullname;

    @Column(nullable =  false, unique =  true)
    private String email;

    @Column(nullable =  false)
    private String password;

    @Column(nullable = false)
    private boolean enabled = false;

    @Column(nullable =  false)
    private boolean accountLocked = false;

    @Column(nullable = false)
    private int failedLoginAttempts = 0;

    private Instant lockedUntil;

    @Column(nullable = false)
    private boolean mfaEnabled = false;

    @Column(nullable =  false, updatable = false)
    private Instant createAt = Instant.now();

    private Instant updateAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles =  new HashSet<>();

    @PreUpdate
    public void onUpdate(){
        this.updateAt = Instant.now();
    }
    
}
