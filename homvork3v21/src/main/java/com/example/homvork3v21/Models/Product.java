package com.example.homvork3v21.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productName;
    private String description;
    private double price;

    @Override
    public String toString() {
        return "Ürün Adı : " + productName + '\'' +
                ", Ürün Detayı : " + description + '\'' +
                ", Ürün Fiyatı : " + price + " TL "
                ;
    }
}
