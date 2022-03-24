package com.hepsiemlak.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long packageId;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private Bank bank;
    private Integer amount;
    private Instant createdAt;
}
