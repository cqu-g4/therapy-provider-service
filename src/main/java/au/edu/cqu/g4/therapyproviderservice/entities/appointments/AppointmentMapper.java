package au.edu.cqu.g4.therapyproviderservice.entities.appointments;

import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.CreateAppointmentDto;
import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.GetUserAppointment;
import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.UserDto;
import au.edu.cqu.g4.therapyproviderservice.entities.doctors.Doctor;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public Appointment toEntityFromCreateAppointmentDto(CreateAppointmentDto dto) {
        return Appointment.builder()
                .doctorId(dto.getDoctorId())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .therapyProviderId(dto.getTherapyProviderId())
                .userId(dto.getUserId())
                .build();
    }

    public GetUserAppointment toGetUserAppointmentDto(Appointment appointment, UserDto user, Doctor doctor) {
        return GetUserAppointment.builder()
                .id(appointment.getId())
                .user(user)
                .doctor(doctor)
                .endDate(appointment.getEndTime())
                .startDate(appointment.getStartTime())
                .therapyProviderId(appointment.getTherapyProviderId())
                .build();
    }
}
