package com.yasas.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BookingEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "bookingId")
    private UUID id;

    private LocalDateTime startingDateTime;

    private LocalDateTime endingDateTime;

    @OneToOne
    @JoinColumn(name = "room_Id")
    @JsonIgnore
    private RoomEntity room;

    @OneToMany(mappedBy = "booking" ,cascade = CascadeType.PERSIST,  orphanRemoval = true)
    @JsonBackReference
    private Set<PaymentEntity> payment;
}
