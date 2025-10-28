package com.yasas.hotel.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Data
@Table(name = "Rooms")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "roomId"
)
public class RoomEntity {
    @Id
    private Long roomId;

    private String type;

    private String description;

    private Double price;

    private Double roomSize;

    private Double minGuestSize;

    private Double maxGuestSize;

//    private String[] amenities;



    @ManyToMany(mappedBy = "rooms", cascade = CascadeType.ALL)
    private List<BookingEntity> booking;

}
