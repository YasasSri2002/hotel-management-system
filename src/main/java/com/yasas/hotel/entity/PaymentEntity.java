package com.yasas.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class PaymentEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    private String amount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private String status;

    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID transactionId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "booking_id" )
    private BookingEntity booking;

}
