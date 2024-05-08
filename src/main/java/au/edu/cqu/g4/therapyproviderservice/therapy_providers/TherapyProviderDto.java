package au.edu.cqu.g4.therapyproviderservice.therapy_providers;

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
