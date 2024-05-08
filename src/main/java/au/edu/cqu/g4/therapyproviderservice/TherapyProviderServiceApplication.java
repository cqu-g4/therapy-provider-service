package au.edu.cqu.g4.therapyproviderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"au.edu.cqu.g4.therapyproviderservice.*", "org.springdoc"})
@EnableFeignClients
public class TherapyProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TherapyProviderServiceApplication.class, args);
    }

}
