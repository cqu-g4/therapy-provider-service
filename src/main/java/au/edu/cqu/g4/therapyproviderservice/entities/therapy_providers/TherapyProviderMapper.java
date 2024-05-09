package au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers;

import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos.CreateTherapyProviderDto;
import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos.TherapyProviderDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TherapyProviderMapper {

    public TherapyProvider toEntity(TherapyProviderDto dto) {
        return TherapyProvider.builder()
                .id(dto.getId())
                .services(dto.getServices())
                .userId(dto.getUserId())
                .build();
    }

    public TherapyProviderDto toDto(TherapyProvider entity) {
        return TherapyProviderDto.builder()
                .id(entity.getId())
                .services(entity.getServices())
                .userId(entity.getUserId())
                .build();
    }

    public List<TherapyProviderDto> toDto(List<TherapyProvider> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public List<TherapyProvider> toEntity(List<TherapyProviderDto> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    public TherapyProvider toEntityFromCreateDto(CreateTherapyProviderDto dto, String userId) {
        return TherapyProvider.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .contactNumber(dto.getContactNumber())
                .establishedDate(dto.getEstablishedDate())
                .userId(userId)
                .build();
    }

    public CreateTherapyProviderDto toCreateTherapyProviderDto(TherapyProvider therapyProvider) {
        return CreateTherapyProviderDto.builder()
                .id(therapyProvider.getId())
                .name(therapyProvider.getName())
                .userId(therapyProvider.getUserId())
                .address(therapyProvider.getAddress())
                .contactNumber(therapyProvider.getContactNumber())
                .establishedDate(therapyProvider.getEstablishedDate())
                .build();
    }
}
