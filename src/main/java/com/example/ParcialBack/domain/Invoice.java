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
@Table(name = "invoices")
public class Invoice {
    @Id
    @Column(name = "invoiceId")
    int id;

    LocalDate invoiceDate;
    String billingAddress;
    String billingCity;
    String billingState;
    String billingCountry;
    String billingPostalCode;
    double total;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    Customer customerId;

    public Invoice(int id, LocalDate invoiceDate, String billingAddress, String billingCity, String billingState, String billingCountry, String billingPostalCode, double total, Customer customerId) {
        this.id = id;
        this.invoiceDate = LocalDate.now();
        this.billingAddress = billingAddress;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.total = total;
        this.customerId = customerId;
    }
}
