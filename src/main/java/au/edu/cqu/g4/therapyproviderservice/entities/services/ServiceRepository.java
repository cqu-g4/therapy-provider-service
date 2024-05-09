package au.edu.cqu.g4.therapyproviderservice.entities.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServiceRepository extends MongoRepository<Service, String> {
    List<Service> searchAllByNameContainingIgnoreCase(String name);
}
