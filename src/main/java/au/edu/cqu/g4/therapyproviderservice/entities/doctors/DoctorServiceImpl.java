package au.edu.cqu.g4.therapyproviderservice.entities.doctors;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAll(String keyword) {
        if(StringUtils.isEmpty(keyword))
            return doctorRepository.searchAllByNameContainingIgnoreCase(keyword);
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(String id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

}
