package com.yasas.hotel.service;

import com.yasas.hotel.model.BookingModel;
import com.yasas.hotel.model.response.BookingResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {

    ResponseEntity<BookingModel> make(BookingModel book);

    ResponseEntity<List<BookingResponseModel>> getAll();

}
