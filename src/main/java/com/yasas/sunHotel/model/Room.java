package com.yasas.sunHotel.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private  Integer roomId;

    private String type;

    private String description;

    private Double price;
}
