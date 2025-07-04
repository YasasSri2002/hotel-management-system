package com.yasas.hotel.controller;

import com.yasas.hotel.entity.BookingEntity;
import com.yasas.hotel.model.BookingModel;
import com.yasas.hotel.model.response.BookingResponseModel;
import com.yasas.hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingModel>make(@RequestBody BookingModel book){
        return bookingService.make(book);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseModel>>getAll(){
        return bookingService.getAll();
    }
}
