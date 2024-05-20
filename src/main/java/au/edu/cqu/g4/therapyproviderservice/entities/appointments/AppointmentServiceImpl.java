package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllByTherapyProviderId(String therapyProviderId) {
        return appointmentRepository.findAppointmentByTherapyProviderId(therapyProviderId);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
