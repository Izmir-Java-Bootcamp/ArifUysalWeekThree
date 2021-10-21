package com.example.homvork3v21.Services.payment;

import com.example.homvork3v21.Models.checkout.Bill;
import com.example.homvork3v21.Models.enums.PaymentType;
import org.springframework.stereotype.Service;


@Service
public interface PaymentInterface {

    void pay(Bill bill);
    PaymentType getType();


}
