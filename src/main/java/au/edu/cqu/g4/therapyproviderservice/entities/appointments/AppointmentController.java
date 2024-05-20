package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.CreateAppointmentDto;
import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.GetUserAppointment;
import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.UserDto;
import au.edu.cqu.g4.therapyproviderservice.entities.doctors.DoctorService;
import au.edu.cqu.g4.therapyproviderservice.proxies.ProxyCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    private final DoctorService doctorService;
    private final ProxyCaller caller;

    @PostMapping
    public ResponseEntity<GetUserAppointment> getAppointment(@RequestBody CreateAppointmentDto dto) {
        UserDto user;
        try {
            user = caller.getUserById(dto.getUserId());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Check for overlapping appointments
        List<Appointment> overlappingAppointments = appointmentService.findOverlappingAppointments(
                dto.getDoctorId(), dto.getStartTime(), dto.getEndTime());

        if (!overlappingAppointments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict if time slot is already booked
        }

        Appointment appointment = appointmentService.save(
                appointmentMapper.toEntityFromCreateAppointmentDto(dto)
        );

        return new ResponseEntity<>(
                appointmentMapper.toGetUserAppointmentDto(
                        appointment,
                        user,
                        doctorService.getById(appointment.getDoctorId())
                ),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GetUserAppointment>> getUserAppointmentByTherapyProvider(@PathVariable String id) {
        List<GetUserAppointment> apptList = appointmentService.getAllByTherapyProviderId(id).stream()
                .map(appt -> appointmentMapper.toGetUserAppointmentDto(
                        appt,
                        getUser(appt.getUserId()),
                        doctorService.getById(appt.getDoctorId()))
                )
                .toList();
        return new ResponseEntity<>(apptList, HttpStatus.OK);
    }

    private UserDto getUser(String userId) {
        return caller.getUserById(userId);
    }
}
