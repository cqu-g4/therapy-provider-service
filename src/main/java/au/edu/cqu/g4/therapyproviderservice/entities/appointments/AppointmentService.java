package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllByTherapyProviderId(String therapyProviderId);
    List<Appointment> findOverlappingAppointments(String doctorId, LocalDateTime startTime, LocalDateTime endTime);
    Appointment save(Appointment doctor);
}
