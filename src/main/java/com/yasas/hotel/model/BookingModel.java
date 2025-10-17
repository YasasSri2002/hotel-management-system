package com.yasas.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingModel {

    private LocalDateTime startingDateTime;

    private LocalDateTime endingDateTime;

    private String status;

    private List<Long> roomId;




}
