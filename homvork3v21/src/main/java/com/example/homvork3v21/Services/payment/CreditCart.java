package com.example.homvork3v21.Services.payment;


import com.example.homvork3v21.Models.checkout.Bill;
import com.example.homvork3v21.Models.enums.PaymentType;
import com.example.homvork3v21.Models.properties.CreditCartProperties;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class CreditCart implements PaymentInterface{
    private CreditCartProperties creditCartProperties;


    @Override
    public void pay(Bill bill) {
        System.out.println("Ödeme Tamamlandı. Ödeme Yöntemi Kredi Kartı. Komisyon : "+ creditCartProperties.getCreditCartCommission());

    }

    @Override
    public PaymentType getType() {
        return PaymentType.CREDITCART;
    }
}
