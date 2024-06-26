package au.edu.cqu.g4.therapyproviderservice.entities.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("services")
public class Service {

    @Id
    private String id;

    private String name;

    private String description;

    private double price;
}
