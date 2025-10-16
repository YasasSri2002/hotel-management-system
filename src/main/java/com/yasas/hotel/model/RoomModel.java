package com.yasas.hotel.model;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomModel {

    private Long roomId;

    private String type;

    private String description;

    private Double price;

    private Double roomSize;

    private Double minGuestSize;

    private Double maxGuestSize;

}
