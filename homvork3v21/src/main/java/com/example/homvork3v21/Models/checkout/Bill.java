package com.example.homvork3v21.Models.checkout;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private List<BillItem> billItems;
    private double totalPrice;
}