package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAppointmentByTherapyProviderId(String therapyProviderId);

    @Query("{ 'doctorId': ?0, 'startTime': { $lt: ?2 }, 'endTime': { $gt: ?1 } }")
    List<Appointment> findOverlappingAppointments(String doctorId, LocalDateTime startTime, LocalDateTime endTime);
}
