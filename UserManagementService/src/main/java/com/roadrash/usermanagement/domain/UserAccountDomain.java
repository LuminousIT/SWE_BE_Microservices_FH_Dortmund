package com.roadrash.usermanagement.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class UserAccountDomain {
    @Id
    @GeneratedValue
    private UUID userId;
    private String name;
    private String email;
    private String password;

//    private VehicleInfo vehicleInfo;

    @Embedded
    private ContactDetails contactDetails;


    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}

@Embeddable
class ContactDetails {


}

enum UserRole {
}
