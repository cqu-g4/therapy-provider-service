package au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentDto {
    private String id;
    private String userId;
    private String doctorId;
    private String therapyProviderId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
