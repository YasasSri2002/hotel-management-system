package com.yasas.hotel.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "Rooms")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoomEntity {

    @Id
    private  Integer roomId;

    private String type;

    private String description;

    private Double price;

    private String time;




}
