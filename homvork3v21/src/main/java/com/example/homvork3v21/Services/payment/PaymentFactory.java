package com.example.homvork3v21.Services.payment;


import com.example.homvork3v21.Models.enums.PaymentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentFactory {

    private final Map<PaymentType,PaymentInterface> paymentMap;

    public PaymentFactory(List<PaymentInterface> paymentList) {
        this.paymentMap = paymentList.stream()
                .collect(Collectors.toMap(PaymentInterface::getType, pm->pm));

    }

    public PaymentInterface getPaymentMethod(PaymentType type){
        return paymentMap.get(type);
    }


}

