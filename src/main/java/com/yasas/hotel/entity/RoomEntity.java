package com.yasas.hotel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@Table(name = "Rooms")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String type;

    private String description;

    private Double price;

    private String time;

    @OneToOne(mappedBy = "room", fetch = FetchType.EAGER)
    private BookingEntity booking;

}
