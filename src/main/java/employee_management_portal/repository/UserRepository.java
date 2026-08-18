package employee_management_portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import employee_management_portal.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    boolean existByEmail(String email);
    boolean existByEmployeeCode(String employeeCode);

    
}
