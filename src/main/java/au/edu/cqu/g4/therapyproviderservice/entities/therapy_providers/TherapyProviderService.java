package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers;

import java.util.List;

public interface TherapyProviderService {
    List<TherapyProvider> getAll();
    TherapyProvider getById(String id);
    TherapyProvider save(TherapyProvider therapyProvider);
    void deleteById(String id);
}
