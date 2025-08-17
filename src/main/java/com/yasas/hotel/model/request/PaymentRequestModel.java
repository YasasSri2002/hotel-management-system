package com.yasas.hotel.model.request;

import lombok.Data;

import java.time.LocalDate;


@Data
public class PaymentRequestModel {


    private String amount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private String status;


}
