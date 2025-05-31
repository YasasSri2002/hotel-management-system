package com.yasas.sunHotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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




}
