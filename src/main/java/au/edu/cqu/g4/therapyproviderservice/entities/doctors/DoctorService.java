package au.edu.cqu.g4.therapyproviderservice.entities.doctors;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAll(String keyword);
    Doctor getById(String id);
    Doctor save(Doctor doctor);
}
