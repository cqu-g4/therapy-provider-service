package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers;

import au.edu.cqu.g4.therapyproviderservice.entities.doctors.Doctor;
import au.edu.cqu.g4.therapyproviderservice.entities.doctors.DoctorService;
import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos.CreateDoctorDto;
import au.edu.cqu.g4.therapyproviderservice.exceptions.CustomBackendException;
import au.edu.cqu.g4.therapyproviderservice.proxies.ProxyCaller;
import au.edu.cqu.g4.therapyproviderservice.proxies.dtos.UserRegistrationDto;
import au.edu.cqu.g4.therapyproviderservice.entities.services.Service;
import au.edu.cqu.g4.therapyproviderservice.entities.services.ServiceService;
import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos.CreateServiceDto;
import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos.CreateTherapyProviderDto;
import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos.TherapyProviderDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TherapyProviderController {

    private final TherapyProviderService therapyProviderService;
    private final ServiceService serviceService;
    private final DoctorService doctorService;
    private final TherapyProviderMapper therapyProviderMapper;

    private final ProxyCaller caller;

    @PostMapping
    public ResponseEntity<CreateTherapyProviderDto> create(@RequestBody CreateTherapyProviderDto dto) {
        UserRegistrationDto userRegistrationDto = caller.createTherapyProviderUser(dto);
        TherapyProvider therapyProvider = therapyProviderService.save(therapyProviderMapper.toEntityFromCreateDto(dto, userRegistrationDto.getUserId()));
        CreateTherapyProviderDto createTherapyProviderDto = therapyProviderMapper.toCreateTherapyProviderDto(therapyProvider);
        createTherapyProviderDto.setEmail(dto.getEmail());
        return new ResponseEntity<>(createTherapyProviderDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TherapyProviderDto> update(@PathVariable String id, @RequestBody TherapyProviderDto dto) {
        if(!StringUtils.equals(id, dto.getId())) throw new CustomBackendException("Id did not match");
        TherapyProvider therapyProvider = therapyProviderService.save(therapyProviderMapper.toEntity(dto));
        return new ResponseEntity<>(therapyProviderMapper.toDto(therapyProvider), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TherapyProviderDto> getById(@PathVariable String id) {
        TherapyProvider therapyProvider = therapyProviderService.getById(id);
        if(therapyProvider == null) throw new CustomBackendException("Therapy Provider not found");

        return new ResponseEntity<>(therapyProviderMapper.toDto(therapyProvider), HttpStatus.OK);
    }

    @PutMapping("/{id}/services")
    public ResponseEntity<TherapyProviderDto> saveTPService(@PathVariable String id, @RequestBody CreateServiceDto createServiceDto) {
        TherapyProvider therapyProvider = therapyProviderService.getById(id);
        if(therapyProvider == null) throw new CustomBackendException("Therapy Provider not found");

        if(StringUtils.isEmpty(createServiceDto.getId())) {
            // save to Service database
            Service saveService = serviceService.save(
                    Service.builder()
                            .name(createServiceDto.getName())
                            .description(createServiceDto.getDescription())
                            .price(createServiceDto.getPrice())
                            .build()
            );
            // add service to therapy provider
            therapyProvider.getServices().add(
                    TPService.builder()
                            .id(saveService.getId())
                            .name(saveService.getName())
                            .build()
            );
        } else  {
            Service service = serviceService.getById(createServiceDto.getId());
            if(service == null) throw new CustomBackendException("Service not found");

            //update service in therapy provider
            therapyProvider.getServices()
                    .forEach(s ->
                    {
                        if(StringUtils.equals(s.getId(), service.getId())) {
                            s.setName(service.getName());
                         }
                    });
            therapyProviderService.save(therapyProvider);
        }

        return new ResponseEntity<>(therapyProviderMapper.toDto(therapyProvider), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/services/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable String id, @PathVariable String serviceId) {
        TherapyProvider therapyProvider = therapyProviderService.getById(id);
        if(therapyProvider == null) throw new CustomBackendException("Therapy Provider not found");

        List<TPService> tpServices = therapyProvider.getServices()
                .stream()
                .filter(service -> !StringUtils.equals(serviceId, service.getId()))
                .toList();

        therapyProvider.setServices(tpServices);
        therapyProviderService.save(therapyProvider);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/doctors")
    public ResponseEntity<TherapyProviderDto> saveTPDoctor(@PathVariable String id, @RequestBody CreateDoctorDto createDoctorDto) {
        TherapyProvider therapyProvider = therapyProviderService.getById(id);
        if(therapyProvider == null) throw new CustomBackendException("Therapy Provider not found");

        if(StringUtils.isEmpty(createDoctorDto.getId())) {
            // save to Service database
            Doctor savedDoctor = doctorService.save(
                    Doctor.builder()
                            .name(createDoctorDto.getName())
                            .specialization(createDoctorDto.getSpecialization())
                            .personalBio(createDoctorDto.getPersonalBio())
                            .build()
            );
            // add service to therapy provider
            therapyProvider.getDoctors().add(
                    TPDoctor.builder()
                            .id(savedDoctor.getId())
                            .name(savedDoctor.getName())
                            .build()
            );
        } else  {
            Doctor doctor = doctorService.getById(createDoctorDto.getId());
            if(doctor == null) throw new CustomBackendException("Service not found");

            //update service in therapy provider
            therapyProvider.getDoctors()
                    .forEach(d ->
                    {
                        if(StringUtils.equals(d.getId(), doctor.getId())) {
                            d.setName(doctor.getName());
                        }
                    });
            therapyProviderService.save(therapyProvider);
        }

        return new ResponseEntity<>(therapyProviderMapper.toDto(therapyProvider), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/doctors/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable String id, @PathVariable String doctorId) {
        TherapyProvider therapyProvider = therapyProviderService.getById(id);
        if(therapyProvider == null) throw new CustomBackendException("Therapy Provider not found");

        List<TPDoctor> tpDoctors = therapyProvider.getDoctors()
                .stream()
                .filter(d -> !StringUtils.equals(doctorId, d.getId()))
                .toList();

        therapyProvider.setDoctors(tpDoctors);
        therapyProviderService.save(therapyProvider);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
