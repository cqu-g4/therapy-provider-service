package au.edu.cqu.g4.therapyproviderservice.proxies;

import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.UserDto;
import au.edu.cqu.g4.therapyproviderservice.proxies.dtos.UserRegistrationDto;
import au.edu.cqu.g4.therapyproviderservice.entities.therapy_providers.dtos.CreateTherapyProviderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProxyCaller {

    private final AuthProxy authProxy;
    private final UserProxy userProxy;

    public UserRegistrationDto createTherapyProviderUser(CreateTherapyProviderDto dto) {
        return authProxy.createUser(
                UserRegistrationDto.builder()
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .firstName(dto.getUserFirstName())
                        .lastName(dto.getUserLastName())
                        .role("THERAPY_PROVIDER")
                        .build()
        );
    }

    public UserDto getUserById(String id) {
        return userProxy.getById(id);
    }
}
