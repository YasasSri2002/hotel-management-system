package com.yasas.hotel.converter;

import com.yasas.hotel.entity.BookingEntity;
import com.yasas.hotel.entity.PaymentEntity;
import com.yasas.hotel.entity.RoomEntity;
import com.yasas.hotel.model.PaymentModel;
import com.yasas.hotel.model.RoomModel;

import com.yasas.hotel.model.response.BookingPaymentResponseModel;

import java.util.HashSet;
import java.util.Set;

public class EntityToModelConverter {

    public static BookingPaymentResponseModel bookingEntityToResponseModel(
            BookingEntity bookingEntity){

        BookingPaymentResponseModel responseModel = new BookingPaymentResponseModel();
        responseModel.setId(bookingEntity.getId());
        responseModel.setEndingDateTime(bookingEntity.getEndingDateTime());
        responseModel.setStartingDateTime(bookingEntity.getStartingDateTime());

        RoomModel roomModel = new RoomModel();
        RoomEntity roomEntity = bookingEntity.getRoom();

        roomModel.setRoomId(roomEntity.getRoomId());
        roomModel.setPrice(roomEntity.getPrice());
        roomModel.setType(roomEntity.getType());
        roomModel.setTime(roomEntity.getTime());
        roomModel.setDescription(roomEntity.getDescription());

        responseModel.setRoom(roomModel);

        Set<PaymentModel> paymentModelSet = new HashSet<>();
        Set<PaymentEntity> paymentEntitieSet = bookingEntity.getPayment();

        paymentEntitieSet.forEach(paymentEntity -> {
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setId(paymentEntity.getId());
            paymentModel.setAmount(paymentEntity.getAmount());
            paymentModel.setPaymentDate(paymentEntity.getPaymentDate());
            paymentModel.setStatus(paymentEntity.getStatus());
            paymentModel.setTransactionId(paymentEntity.getTransactionId());
            paymentModel.setPaymentMethod(paymentEntity.getPaymentMethod());
            paymentModelSet.add(paymentModel);
        });

        responseModel.setPayment(paymentModelSet);


        return responseModel;


    }

}
