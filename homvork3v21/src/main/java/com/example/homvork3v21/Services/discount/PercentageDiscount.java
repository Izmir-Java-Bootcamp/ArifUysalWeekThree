package com.example.homvork3v21.Services.discount;

import com.example.homvork3v21.Models.properties.DiscountProperties;
import com.example.homvork3v21.Models.cart.Cart;
import com.example.homvork3v21.Models.cart.CartItem;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;




@Service
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PercentageDiscount implements Discount{
    private final DiscountProperties discountProperties;

    @Override
    public void applyDiscount(Cart cart) {
        for (CartItem cartItem:cart.getCartItems()) {
            double appliedDiscount = (cartItem.getPrice() * cartItem.getQuantity())*((100-discountProperties.getPercentage())/100);
            cartItem.setAppliedDiscount(appliedDiscount);
        }
    }

    @Override
    public boolean isAcceptable(Cart cart) {
        if (cart.cartTotalPrice() >= 1000) {
            return true;
        } else {
            return false;
        }
    }
}
