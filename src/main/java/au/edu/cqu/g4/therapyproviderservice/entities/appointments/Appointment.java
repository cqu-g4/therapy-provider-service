package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("appointments")
public class Appointment {

    @Id
    private String id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String doctorId;

    private String therapyProviderId;

    private String userId;

}
