package au.edu.cqu.g4.therapyproviderservice.therapy_providers;

import au.edu.cqu.g4.therapyproviderservice.shared_entities.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("therapy_providers")
public class TherapyProvider {

    @Id
    private String id;

    @Field("user_id")
    private String userId;

    private String name;

    @Field("established_date")
    private LocalDate establishedDate;

    private Address address;

    @Field("contact_number")
    private String contactNumber;

    private List<TPService> services = new ArrayList<>();

}
