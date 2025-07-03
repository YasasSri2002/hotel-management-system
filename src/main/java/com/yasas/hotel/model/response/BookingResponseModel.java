package com.yasas.hotel.model.response;

import com.yasas.hotel.entity.RoomEntity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookingResponseModel {

    private UUID id;

    private LocalDateTime startingDateTime;

    private LocalDateTime endingDateTime;

    private RoomEntity room;
}
