package com.yasas.hotel.model.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequestModel {

    private LocalDateTime startingDateTime;

    private LocalDateTime endingDateTime;

    private Long roomId;

}
