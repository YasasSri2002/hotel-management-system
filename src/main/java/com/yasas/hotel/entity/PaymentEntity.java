package com.yasas.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name="payment")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    private String amount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private String status;

    private UUID transactionId;
}
