package com.example.ParcialBack.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employeeId")
    int id;

    String lastName;
    String firstName;
    String title;
    LocalDate birthDate;
    LocalDate hireDate;
    String address;
    String city;
    String state;
    String country;
    String postalCode;
    String phone;
    String fax;
    String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reportsTo")
    Employee employeeId;

    public Employee(int id, String lastName, String firstName, String title, LocalDate birthDate, LocalDate hireDate, String address, String city, String state, String country, String postalCode, String phone, String fax, String email, Employee employeeId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.birthDate = birthDate;
        this.hireDate = LocalDate.now();
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.employeeId = employeeId;
    }
}
