package com.yasas.hotel.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomModel {

    private  Integer roomId;

    private String type;

    private String description;

    private Double price;

    private String time;
}
