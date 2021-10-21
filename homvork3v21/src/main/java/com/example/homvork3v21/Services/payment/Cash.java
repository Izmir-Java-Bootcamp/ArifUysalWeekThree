package com.example.homvork3v21.Services.payment;


import com.example.homvork3v21.Models.checkout.Bill;
import com.example.homvork3v21.Models.enums.PaymentType;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Cash implements PaymentInterface {


    @Override
    public void pay(Bill bill) {
        System.out.println("Ödeme tamamlandı.Ödeme Yöntemi :Nakit.Komisyon yok.");

    }

    @Override
    public PaymentType getType() {
        return PaymentType.CASH;
    }
}