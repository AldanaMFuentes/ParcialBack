package com.example.ParcialBack.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customerId")
    int id;

    String firstName;
    String lastName;
    String company;
    String address;
    String city;
    String country;
    String postalCode;
    String phone;
    String fax;
    String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supportRepId")
    Employee employeeId;
}
