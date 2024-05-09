package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos;

import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.TPService;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TherapyProviderDto {
    private String id;
    private String userId;
    private List<TPService> services = new ArrayList<>();
}
