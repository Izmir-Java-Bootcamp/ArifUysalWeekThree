package com.example.homvork3v21.Models.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix = "discount")
@Data
public class DiscountProperties {
    private double percentage;

}

