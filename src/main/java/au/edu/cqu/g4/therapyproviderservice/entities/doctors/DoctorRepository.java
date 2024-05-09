package au.edu.cqu.g4.therapyproviderservice.entities.doctors;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> searchAllByNameContainingIgnoreCase(String name);
}
