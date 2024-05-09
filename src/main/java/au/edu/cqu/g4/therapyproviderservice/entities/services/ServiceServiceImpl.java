package au.edu.cqu.g4.therapyproviderservice.entities.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<Service> getAll(String keyword) {
        if(StringUtils.isEmpty(keyword))
            return serviceRepository.searchAllByNameContainingIgnoreCase(keyword);
        return serviceRepository.findAll();
    }

    @Override
    public Service getById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }

}
