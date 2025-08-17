package com.yasas.hotel.model.request;


import lombok.Data;

import java.util.Set;

@Data
public class BookingPaymentRequestModel {

    private BookingRequestModel booking;

    private Set<PaymentRequestModel> payment;

}
