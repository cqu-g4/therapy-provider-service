package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findAppointmentByTherapyProviderId(String therapyProviderId);
}
