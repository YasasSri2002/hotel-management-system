package com.yasas.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.hotel.entity.BookingEntity;
import com.yasas.hotel.entity.RoomEntity;
import com.yasas.hotel.exception.RoomIsNotFoundException;
import com.yasas.hotel.model.BookingModel;
import com.yasas.hotel.model.response.BookingResponseModel;
import com.yasas.hotel.repository.BookingRepository;
import com.yasas.hotel.repository.RoomRepository;
import com.yasas.hotel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final RoomRepository roomRepository;

    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<BookingModel> make(BookingModel book) {

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStartingDateTime(book.getStartingDateTime());
        bookingEntity.setEndingDateTime(book.getEndingDateTime());

        RoomEntity room = roomRepository.findById(book.getRoomId()).orElseThrow(() -> new
                RoomIsNotFoundException("room is not found")
        );
        bookingEntity.setRoom(room);


        return ResponseEntity.ok(mapper.convertValue(
                bookingRepository.save(bookingEntity),BookingModel.class
        ));
    }

    @Override
    public ResponseEntity<List<BookingResponseModel>> getAll() {
        Iterable<BookingEntity> allData = bookingRepository.findAll();

        ArrayList<BookingResponseModel> bookingEntities = new ArrayList<>();

        allData.forEach(data -> bookingEntities.add(
                mapper.convertValue(
                        data,BookingResponseModel.class)
        ));

        return ResponseEntity.ok(bookingEntities);
    }
}
