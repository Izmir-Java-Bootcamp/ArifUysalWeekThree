package com.example.homvork3v21.Services.discount;

import com.example.homvork3v21.Models.Product;
import com.example.homvork3v21.Models.cart.Cart;
import com.example.homvork3v21.Models.cart.CartItem;
import lombok.Data;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


@Service
@Data
public class Buy2Take3Discount implements Discount {
    @Override
    public void applyDiscount(Cart cart) {
        for (CartItem cartItem : cart.getCartItems()) {
            double newDiscount = cartItem.getProduct().getPrice() * (cartItem.getQuantity() / 3);
            cartItem.setAppliedDiscount(newDiscount);
        }
    }

    @Override
    public boolean isAcceptable(Cart cart) {
        int value = cart.getCartItems().stream()
                .map(CartItem::getQuantity)
                .max(Integer::compare).get();
        return value > 2;
    }

}

