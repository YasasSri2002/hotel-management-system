package com.yasas.hotel.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booking")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class BookingEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "bookingId")
    private UUID id;

    private LocalDateTime startingDateTime;

    private LocalDateTime endingDateTime;

    @OneToOne
    @JoinColumn(name = "room_Id")
    private RoomEntity room;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<PaymentEntity> payment;
}
