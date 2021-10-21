package com.example.homvork3v21.Services.discount;
import com.example.homvork3v21.Models.cart.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DiscountStrategy {
    private final List<Discount> discounts;

    public void applyDiscount(Cart cart) {
        for (Discount discount: discounts) {
            if (discount.isAcceptable(cart)){
                discount.applyDiscount(cart);
                break;
            }
        }
    }


}