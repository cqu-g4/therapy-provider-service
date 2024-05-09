package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TherapyProviderRepository extends MongoRepository<TherapyProvider, String> {
}
