package com.example.homvork3v21.Models.cart;
import com.example.homvork3v21.Models.Product;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;
    private double appliedDiscount;


    public double getPrice() {
        return product.getPrice() * quantity ;
    }
    public double getUnitPrice(){
        return (product.getPrice() * quantity-appliedDiscount)/quantity;
    }
    public double getDiscountedPrice(){
        return (product.getPrice() * quantity) - appliedDiscount;
    }

}
