package com.yasas.hotel.model.response;

import com.yasas.hotel.model.BookingModel;
import com.yasas.hotel.model.PaymentModel;
import com.yasas.hotel.model.RoomModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingPaymentResponseModel {

    private UUID id;

    private LocalDateTime startingDateTime;

    private LocalDateTime endingDateTime;


    private RoomModel room;

    private Set<PaymentModel> payment;

}
