package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllByTherapyProviderId(String therapyProviderId);
    Appointment save(Appointment doctor);
}
