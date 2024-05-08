package au.edu.cqu.g4.therapyproviderservice.therapy_providers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TherapyProviderServiceImpl implements TherapyProviderService {

    private final TherapyProviderRepository therapyProviderRepository;

    @Override
    public List<TherapyProvider> getAll() {
        return therapyProviderRepository.findAll();
    }

    @Override
    public TherapyProvider getById(String id) {
        return therapyProviderRepository.findById(id)
                .orElse(null);
    }

    @Override
    public TherapyProvider save(TherapyProvider therapyProvider) {
        return therapyProviderRepository.save(therapyProvider);
    }

    @Override
    public void deleteById(String id) {
        therapyProviderRepository.deleteById(id);
    }
}
