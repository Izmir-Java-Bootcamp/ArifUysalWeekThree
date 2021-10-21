package com.example.homvork3v21;

import com.example.homvork3v21.Categories.Categories;
import com.example.homvork3v21.Categories.MainCategory;
import com.example.homvork3v21.Categories.SubCategory;
import com.example.homvork3v21.Models.Product;
import com.example.homvork3v21.Models.cart.Cart;
import com.example.homvork3v21.Models.cart.CartItem;
import com.example.homvork3v21.Models.checkout.Bill;
import com.example.homvork3v21.Models.checkout.BillItem;
import com.example.homvork3v21.Models.enums.PaymentType;
import com.example.homvork3v21.Models.properties.CreditCartProperties;
import com.example.homvork3v21.Models.properties.DeliveryProperties;
import com.example.homvork3v21.Models.properties.DiscountProperties;
import com.example.homvork3v21.Services.discount.DiscountStrategy;

import com.example.homvork3v21.Services.payment.PaymentFactory;
import com.example.homvork3v21.Services.payment.PaymentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Demo implements CommandLineRunner {
    private final Scanner scanner;
    private final Cart cart;
    private final DiscountProperties discountProperties;
    private final CreditCartProperties creditCartProperties;
    private final DeliveryProperties deliveryProperties;
    private final DiscountStrategy discountStrategy;
    private final PaymentFactory paymentFactory;

    Categories categories = new Categories();

    MainCategory fruitAndVegetable = new MainCategory("Fruit and Vegetable");

    MainCategory snack = new MainCategory("Snack");

    MainCategory breakfast = new MainCategory("Breakfast");
    


    SubCategory fruit = new SubCategory("Fruit and Vegetable", "Fruit");
    SubCategory vegetable = new SubCategory("Fruit and Vegetable", "Vegetable");

    SubCategory chips = new SubCategory("Snack", "Chips");
    SubCategory chocolate = new SubCategory("Snack", "Chocolate");

    SubCategory milk = new SubCategory("Breakfast", "Milk");
    SubCategory delicatessen = new SubCategory("Breakfast", "Delicatessen");



    Product apple = new Product("Apple", "test", 1.0);
    Product pear = new Product("Pear", "test", 2.5);
    Product grape = new Product("Grape", "test", 3.5);

    Product tomato = new Product("Tomato", "test", 4.5);
    Product pepper = new Product("Pepper", "test", 5.5);
    Product eggplant = new Product("Eggplant", "test", 6.5);

    Product lays = new Product("Lays", "test", 7.5);
    Product doritos = new Product("Doritos", "test", 8.5);
    Product ruffles = new Product("Ruffles", "test", 9.5);

    Product tadelle = new Product("Tadelle", "test", 10.5);
    Product albeni = new Product("Albeni", "test", 11.5);
    Product hobby = new Product("Hobby", "test", 12.5);

    Product fullfat = new Product("Full-Fat", "test", 13.5);
    Product lowfat = new Product("Low-Fat", "test", 14.5);
    Product lactofree = new Product("Lacto-Free", "test", 15.5);

    Product cheddar = new Product("Cheddar", "test", 16.5);
    Product cheese = new Product("Cheese", "test", 17.5);
    Product olive = new Product("Olive", "test", 18.5);



    @Override
    public void run(String... args) throws Exception {


        categories.addCategory(fruitAndVegetable);
        categories.addCategory(snack);
        categories.addCategory(breakfast);



        fruitAndVegetable.addCategory(fruit);
        fruitAndVegetable.addCategory(vegetable);

        snack.addCategory(chips);
        snack.addCategory(chocolate);

        breakfast.addCategory(milk);
        breakfast.addCategory(delicatessen);

        fruit.addProduct(apple);
        fruit.addProduct(pear);
        fruit.addProduct(grape);

        vegetable.addProduct(tomato);
        vegetable.addProduct(pepper);
        vegetable.addProduct(eggplant);

        chips.addProduct(lays);
        chips.addProduct(doritos);
        chips.addProduct(ruffles);

        chocolate.addProduct(tadelle);
        chocolate.addProduct(albeni);
        chocolate.addProduct(hobby);

        milk.addProduct(fullfat);
        milk.addProduct(lowfat);
        milk.addProduct(lactofree);

        delicatessen.addProduct(cheddar);
        delicatessen.addProduct(cheese);
        delicatessen.addProduct(olive);





        while (true) {
            System.out.println("Kodluyoruz Markete Hoşgeldiniz! Menülere ulaşmak için 1 , Arama yapmak için 2 , Çıkış için 3ü tuşlayabilirsiniz");
            int i = scanner.nextInt();
            scanner.nextLine();
            if (i == 1) {
                mainMenu();

            } else if (i == 2) {

            }
            else if ( i == 3) {
                break;
            }
            else{
                throw new IllegalArgumentException();
            }
        }

    }
    void mainMenu() {
        List<MainCategory> mainCategoryList = categories.getMainCategoryList();
        Cart cart = new Cart();
        System.out.println("Ana Kategoriler");
        System.out.println(categories.getMainCategoryList());
        String mainChoice = scanner.nextLine();

        System.out.println("Alt Kategoriler");

        for (MainCategory mainCategory : mainCategoryList) {
            if (mainCategory.getMainName().equals(mainChoice)) {
                mainCategory.getSubCategoryList().stream().forEach(System.out::println);
            }
        }
        String subChoice = scanner.nextLine();
        System.out.println("Ürünler");
        for (MainCategory mainCategory : mainCategoryList){
            if (mainCategory.getSubCategoryList().get(0).getSubName().equals(subChoice)){
                mainCategory.getSubCategoryList().get(0).getProductList().stream().forEach(System.out::println);

            }
        }

        System.out.println("Almak istediğiniz ürünü yazın.");
        String productChoice = scanner.nextLine();
        System.out.println("Kaç tane almak istiyorsunuz?");
        int quantity = scanner.nextInt();
        Product lastproduct = null;
        for (MainCategory mainCategory : mainCategoryList){
            if (mainCategory.getSubCategoryList().get(0).getProductList().get(0).getProductName().equals(productChoice)){
                for ( MainCategory mainCategory1 : mainCategoryList){
                    for ( SubCategory subCategory : mainCategory1.getSubCategoryList()){
                        for( Product product : subCategory.getProductList()){
                            if ( product.getProductName().equals(productChoice)){
                                lastproduct = product;
                            }
                        }
                    }
                CartItem cartItem=CartItem.builder()
                        .product(lastproduct)
                        .quantity(quantity)
                        .appliedDiscount(discountProperties.getPercentage())
                        .build();
                cart.addItem(cartItem);
               discountStrategy.applyDiscount(cart);



            }
        }

        System.out.println("Checkout için 1, Başa dönmek için herhangi bir tuşa basın.");
        int choice = scanner.nextInt();
        if ( choice == 1 ){
            BillItem billItem = BillItem.builder()
                    .price(cart.cartTotalPrice())
                    .quantity(cart.getCartItems().get(0).getQuantity())
                    .appliedCommission(creditCartProperties.getCreditCartCommission())
                    .deliveredFee(deliveryProperties.getDeliveryFee())
                    .build();



            System.out.println(billItem);
            System.out.println("Ödemeyi nasıl yapmak istersiniz? 1.Cash 2.CreditCart");
            int choice2 = scanner.nextInt();
            Bill bill = new Bill();
            if( choice2 == 1 ){
                PaymentInterface payment = paymentFactory.getPaymentMethod(PaymentType.CASH);
                payment.pay(bill);

            }
            else if (choice2 == 2 ){
                PaymentInterface payment = paymentFactory.getPaymentMethod(PaymentType.CREDITCART);
                payment.pay(bill);
            }

        }
        System.out.println("Yine bekleriz");


    }
    }
}




