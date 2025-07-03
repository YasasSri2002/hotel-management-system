package com.yasas.hotel.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomModel {

    private Long roomId;

    private String type;

    private String description;

    private Double price;

    private String time;
}
