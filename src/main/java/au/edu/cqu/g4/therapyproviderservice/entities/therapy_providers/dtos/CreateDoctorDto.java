package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos;

import lombok.Data;

@Data
public class CreateDoctorDto {
    private String id;
    private String name;
    private String specialization;
    private String personalBio;
}
