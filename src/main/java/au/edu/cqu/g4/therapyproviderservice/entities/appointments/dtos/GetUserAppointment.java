package au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos;

import au.edu.cqu.g4.therapyproviderservice.entities.doctors.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserAppointment {
    private String id;
    private Doctor doctor;
    private String therapyProviderId;
    private String therapyProviderName;
    private UserDto user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
