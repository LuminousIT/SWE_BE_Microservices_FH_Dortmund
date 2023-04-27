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

//    public UserAc

    // Getters and setters

    // equals and hashCode methods

    // toString method
}

@Embeddable
class ContactDetails {
    private String phoneNumber;
    private String address;
    private String additionalContactInfo;

    // Getters and setters

    // equals and hashCode methods

    // toString method
}

enum UserRole {
    REGULAR_USER,
    ADMINISTRATOR,
    SUPPORT_ST
}
