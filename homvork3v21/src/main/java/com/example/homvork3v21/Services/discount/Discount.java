package com.example.homvork3v21.Services.discount;

import com.example.homvork3v21.Models.cart.Cart;
import org.springframework.stereotype.Service;

@Service
public interface Discount {
    boolean isAcceptable(Cart cart);
    void applyDiscount(Cart cart);
}
