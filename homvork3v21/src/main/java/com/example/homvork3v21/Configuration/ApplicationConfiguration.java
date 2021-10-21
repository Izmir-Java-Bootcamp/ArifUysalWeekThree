package com.example.homvork3v21.Configuration;

import com.example.homvork3v21.Models.cart.CartItem;
import com.example.homvork3v21.Models.properties.DiscountProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;
@Configuration
public class ApplicationConfiguration {
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
    }

