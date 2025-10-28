package com.yasas.hotel.service;

import com.yasas.hotel.model.BookingModel;
import com.yasas.hotel.model.request.BookingPaymentRequestModel;
import com.yasas.hotel.model.response.BookingPaymentResponseModel;
import com.yasas.hotel.model.response.BookingResponseModel;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    ResponseEntity<BookingModel> bookingWithoutPayment(BookingModel book);

    ResponseEntity<List<BookingResponseModel>> getAll();

    ResponseEntity<BookingPaymentResponseModel> bookingWithPayment(
            BookingPaymentRequestModel bookingPaymentRequest
    );

    ResponseEntity<String>checkRoomAvailability(
            Long roomId, LocalDateTime startDate , LocalDateTime endDate
    );

}
