package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<Appointment> findOverlappingAppointments(String doctorId, LocalDateTime startTime, LocalDateTime endTime) {
        return appointmentRepository.findOverlappingAppointments(doctorId, startTime, endTime);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
