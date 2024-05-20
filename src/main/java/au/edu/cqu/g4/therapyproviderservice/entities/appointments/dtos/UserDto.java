package au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private String id;
    private String name;
}
