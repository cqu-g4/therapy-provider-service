package au.edu.cqu.g4.therapyproviderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"au.edu.cqu.g4.therapyproviderservice.*", "org.springdoc"})
public class TherapyProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TherapyProviderServiceApplication.class, args);
    }

}
