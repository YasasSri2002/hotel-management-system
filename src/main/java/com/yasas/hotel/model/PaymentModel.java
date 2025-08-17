package com.yasas.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PaymentModel {

    private UUID id;

    private String amount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private String status;

    private UUID transactionId;

}
