package com.example.homvork3v21.Models.cart;

import com.example.homvork3v21.Models.properties.DeliveryProperties;
import com.example.homvork3v21.Models.properties.DiscountProperties;
import com.example.homvork3v21.Services.discount.DiscountStrategy;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class Cart {
    private final List<CartItem> cartItems;
    private DiscountProperties discountProperties;
    private DeliveryProperties deliveryProperties;
    private DiscountStrategy discountStrategy;


    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(CartItem cartItem){
        cartItems.add(cartItem);
    }

    public double cartTotalPrice(){
        double cartTotal = 0;
        double discountTotal = 0;
        for (CartItem cartItem : cartItems ) {
            cartTotal = cartTotal + cartItem.getPrice();
            discountTotal = discountTotal + cartItem.getAppliedDiscount();
        }
        return cartTotal-discountTotal;
    }

    public List<CartItem> getCartItems(){
        return cartItems;
    }

}
