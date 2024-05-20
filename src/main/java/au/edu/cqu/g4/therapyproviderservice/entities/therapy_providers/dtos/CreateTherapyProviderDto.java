package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class CreateTherapyProviderDto {
    private String id;
    private String userId;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate establishedDate;
    private String userFirstName;
    private String userLastName;
    private String email;
    private String password;
    private String address;
    private String contactNumber;
}
