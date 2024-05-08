package au.edu.cqu.g4.therapyproviderservice.proxies;

import au.edu.cqu.g4.therapyproviderservice.proxies.dtos.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "AUTH-SERVICE", path = "auth")
public interface AuthProxy {

    @PostMapping("/users/register")
    UserRegistrationDto createUser(@RequestBody UserRegistrationDto userRegistrationRecord);
}
