package employee_management_portal.dto;

import java.util.List;

import employee_management_portal.entity.User;

public record EmployeeDto(
    Long id,
    String employeeCode,
    String fullName,
    String email,
    boolean enabled,
    boolean accountLocked,
    List<String> roles
) {

    public static EmployeeDto from(User user){
        return new EmployeeDto(
            user.getId(), 
            user.getEmployeeCode(), 
            user.getFullname(), 
            user.getEmail(), 
            user.isEnabled(), 
            user.isAccountLocked(), 
            user.getRoles().stream().map(r -> r.getName().name()).toList()
        );
    }
}
