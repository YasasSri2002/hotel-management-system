package com.yasas.hotel.entity;

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




}
