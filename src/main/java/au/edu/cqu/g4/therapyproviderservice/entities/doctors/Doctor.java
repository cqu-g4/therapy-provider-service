package au.edu.cqu.g4.therapyproviderservice.entities.doctors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("doctors")
public class Doctor {

    @Id
    private String id;

    private String name;

    private String specialization;

    @Field("personal_bio")
    private String personalBio;

}
