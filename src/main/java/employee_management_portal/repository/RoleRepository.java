package employee_management_portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import employee_management_portal.entity.Role;
import employee_management_portal.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);
    
}
