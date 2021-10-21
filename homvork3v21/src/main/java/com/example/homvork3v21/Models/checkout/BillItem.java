package com.example.homvork3v21.Models.checkout;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillItem {
    private String productName;
    private int quantity;
    private double price;
    private double deliveredFee;
    private double appliedCommission;

    @Override
    public String toString() {
        return
                " Ürün adı " + productName + '\'' +
                " Miktarı " + quantity +
                " Ödenecek İndirimli Fiyat " + price + " TL "+
                " Teslimat Ücreti " + deliveredFee +"TL"+
                " Uygulanan Komisyon " + appliedCommission + "TL";
    }
}