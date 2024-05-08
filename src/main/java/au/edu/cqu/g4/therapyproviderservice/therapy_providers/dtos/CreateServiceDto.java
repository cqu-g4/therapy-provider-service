package au.edu.cqu.g4.therapyproviderservice.therapy_providers.dtos;

import lombok.Data;

@Data
public class CreateServiceDto {
    private String id;
    private String name;
    private String description;
    private double price;
}
