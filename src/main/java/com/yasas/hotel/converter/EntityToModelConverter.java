package com.yasas.hotel.converter;

import com.yasas.hotel.entity.BookingEntity;
import com.yasas.hotel.entity.PaymentEntity;
import com.yasas.hotel.entity.RoomEntity;
import com.yasas.hotel.model.PaymentModel;
import com.yasas.hotel.model.RoomModel;

import com.yasas.hotel.model.response.BookingPaymentResponseModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EntityToModelConverter {

    public static BookingPaymentResponseModel bookingEntityToResponseModel(
            BookingEntity bookingEntity){

        BookingPaymentResponseModel responseModel = new BookingPaymentResponseModel();
        responseModel.setId(bookingEntity.getId());
        responseModel.setEndingDateTime(bookingEntity.getEndingDateTime());
        responseModel.setStartingDateTime(bookingEntity.getStartingDateTime());


        List<RoomEntity> roomsList = bookingEntity.getRooms();
        ArrayList<RoomModel> roomModels = new ArrayList<>();
        roomsList.forEach(roomEntity -> {
            RoomModel roomModel = new RoomModel();
            roomModel.setRoomId(roomEntity.getRoomId());
            roomModel.setPrice(roomEntity.getPrice());
            roomModel.setType(roomEntity.getType());
            roomModel.setTime(roomEntity.getTime());
            roomModel.setDescription(roomEntity.getDescription());
            roomModels.add(roomModel);

        });


        responseModel.setRooms(roomModels);

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
