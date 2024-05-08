package au.edu.cqu.g4.therapyproviderservice.shared_entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Address {

    @Field("street_address1")
    private String streetAddress1;

    @Field("street_address2")
    private String streetAddress2;

    @Field("suburb")
    private String suburb;

    @Field("state")
    private String state;

    @Field("postcode")
    private String postcode;

}
