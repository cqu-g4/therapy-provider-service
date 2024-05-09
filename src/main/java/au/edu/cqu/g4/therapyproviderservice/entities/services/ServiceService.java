package au.edu.cqu.g4.therapyproviderservice.entities.services;

import java.util.List;

public interface ServiceService {
    List<Service> getAll(String keyword);
    Service getById(String id);
    Service save(Service service);
}
