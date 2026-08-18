package employee_management_portal.common;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(boolean success, String message, T data, Instant timestemp) {

    public static <T> ApiResponse<T> ok(String message, T data){
        return new ApiResponse<T>(true, message, data, Instant.now());
    }

    public static ApiResponse<Void> ok(String message){
        return new ApiResponse<Void>(true, message, null, Instant.now());
    }
    
    public static ApiResponse<Void> error(String message){
        return new ApiResponse<Void>(false, message, null, Instant.now());
    }
} 
