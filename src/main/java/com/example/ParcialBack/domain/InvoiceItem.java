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
@Table(name = "invoice_items")
public class InvoiceItem {
    @Id
    @Column(name = "invoiceLineId")
    int id;

    double unitPrice;
    int quantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoiceId")
    Invoice invoiceId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trackId")
    Track trackId;
}
