package com.example.homvork3v21.Models.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "delivery")
public class DeliveryProperties {
    private int deliveryFee;
    private int deliveryFeeLimit;
}

