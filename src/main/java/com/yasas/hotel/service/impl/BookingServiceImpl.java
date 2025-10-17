package com.yasas.hotel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yasas.hotel.entity.BookingEntity;
import com.yasas.hotel.entity.PaymentEntity;
import com.yasas.hotel.entity.RoomEntity;
import com.yasas.hotel.model.BookingModel;
import com.yasas.hotel.model.request.BookingPaymentRequestModel;
import com.yasas.hotel.model.response.BookingPaymentResponseModel;
import com.yasas.hotel.model.response.BookingResponseModel;
import com.yasas.hotel.repository.BookingRepository;
import com.yasas.hotel.repository.RoomRepository;
import com.yasas.hotel.service.BookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import static com.yasas.hotel.converter.EntityToModelConverter.bookingEntityToResponseModel;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final RoomRepository roomRepository;


    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<BookingModel> bookingWithoutPayment(BookingModel book) {

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setStartingDateTime(book.getStartingDateTime());
        bookingEntity.setEndingDateTime(book.getEndingDateTime());
        bookingEntity.setStatus(book.getStatus());

        Iterable<RoomEntity> allRooms = roomRepository.findAllById(book.getRoomId());

        bookingEntity.setRooms((List<RoomEntity>) allRooms);


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

    @Override
    @Transactional
    public ResponseEntity<BookingPaymentResponseModel> bookingWithPayment
            (BookingPaymentRequestModel bookingPaymentRequest) {

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setStartingDateTime(
                bookingPaymentRequest.getBooking().getStartingDateTime());

        bookingEntity.setEndingDateTime(
                bookingPaymentRequest.getBooking().getEndingDateTime());

        bookingEntity.setStatus(
                bookingPaymentRequest.getBooking().getStatus()
        );

        Iterable<RoomEntity> allRoomBook =
                roomRepository.findAllById(bookingPaymentRequest.getBooking().getRoomId());

        bookingEntity.setRooms((List<RoomEntity>) allRoomBook);


        HashSet<PaymentEntity> paymentEntitiesSet = new HashSet<>();

        bookingPaymentRequest.getPayment().forEach(paymentModel -> {
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setPaymentDate(paymentModel.getPaymentDate());
            paymentEntity.setPaymentMethod(paymentModel.getPaymentMethod());
            paymentEntity.setAmount(paymentModel.getAmount());
            paymentEntity.setStatus(paymentModel.getStatus());
            paymentEntity.setBooking(bookingEntity);
            paymentEntitiesSet.add(paymentEntity);
        });

        bookingEntity.setPayment(paymentEntitiesSet);

        BookingEntity savedBookingEntity = bookingRepository.save(bookingEntity);

        ArrayList<BookingEntity> bookingEntities = new ArrayList<>();
        bookingEntities.add(savedBookingEntity);

        allRoomBook.forEach(rooms->rooms.setBooking(bookingEntities));

        BookingPaymentResponseModel responseModel =
                bookingEntityToResponseModel(savedBookingEntity);

        return ResponseEntity.ok(responseModel);
    }
}
