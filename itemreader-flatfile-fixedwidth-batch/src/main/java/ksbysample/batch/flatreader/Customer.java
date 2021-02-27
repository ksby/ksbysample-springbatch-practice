package ksbysample.batch.flatreader;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private String firstName;

    private String middleInitial;

    private String lastName;

    private String addressNumber;

    private String street;

    private String city;

    private String state;

    private String zipCode;

}
