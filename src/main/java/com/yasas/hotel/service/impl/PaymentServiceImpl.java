package com.yasas.hotel.service.impl;

import com.yasas.hotel.repository.PaymentRepository;
import com.yasas.hotel.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;



}
