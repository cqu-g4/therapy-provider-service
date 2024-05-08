package au.edu.cqu.g4.therapyproviderservice.proxies.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationDto {
    private String userId;
    private String email;
    private String password;
    private String role;
}
