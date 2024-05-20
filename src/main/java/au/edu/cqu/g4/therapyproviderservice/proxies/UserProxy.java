package au.edu.cqu.g4.therapyproviderservice.proxies;

import au.edu.cqu.g4.therapyproviderservice.entities.appointments.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "USER-SERVICE", path = "users")
public interface UserProxy {

    @GetMapping("/{id}")
    UserDto getById(@PathVariable String id);

}