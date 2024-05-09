package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TPService {
    private String id;
    private String name;
    private double price;
}
