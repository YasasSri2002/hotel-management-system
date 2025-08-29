package com.yasas.hotel.model.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingRequestModel {

    private LocalDateTime startingDateTime;

    private LocalDateTime endingDateTime;

    private String status;

    private List<Long> roomId;

}
