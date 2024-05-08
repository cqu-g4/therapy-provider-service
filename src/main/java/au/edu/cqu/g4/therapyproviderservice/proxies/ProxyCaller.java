package au.edu.cqu.g4.therapyproviderservice.proxies;

import au.edu.cqu.g4.therapyproviderservice.proxies.dtos.UserRegistrationDto;
import au.edu.cqu.g4.therapyproviderservice.therapy_providers.dtos.CreateTherapyProviderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProxyCaller {

    private final AuthProxy authProxy;

    public UserRegistrationDto createTherapyProviderUser(CreateTherapyProviderDto dto) {
        return authProxy.createUser(
                UserRegistrationDto.builder()
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .role("THERAPY_PROVIDER")
                        .build()
        );
    }
}
