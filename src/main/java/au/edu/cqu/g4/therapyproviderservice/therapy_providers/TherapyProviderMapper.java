package au.edu.cqu.g4.therapyproviderservice.therapy_providers;

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
}
