package com.onlineshop;


import com.onlineshop.items.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CheckoutHandler {

    private LocalDate deliveryWindowStart;
    private LocalDate deliveryWindowEnd;

    public double calculateTotal(List<Item> items, String voucher, String membership, String address){

        double baseTotal = 0;

        // sum up the prices
        List<Double> prices = new ArrayList<>();
        for(Item item : items){
            prices.add(item.price());
        }

        for(double price : prices){
            baseTotal = baseTotal + price;
        }

        // check if voucher is valid
        if(voucher.equals("GIMME_DISCOUNT") || voucher.equals("CHEAPER_PLEASE")){
             baseTotal = BigDecimal.valueOf(baseTotal * 0.95).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        } else {
            System.out.println("Voucher invalid");
        }

        // handle delivery fee
        if(membership.equalsIgnoreCase("GOLD")){
            // do nothing
        } else {
            if(Pattern.matches(".*US.*", address)){
                System.out.println("Adding flat delivery fee of 5 USD");
                baseTotal = baseTotal + 5;
            } else {
                System.out.println("Adding flat global delivery fee of 10 USD");
                baseTotal = baseTotal + 10;
            }
        }
        return baseTotal;
    }


    public void setDeliveryTimeWindow(LocalDate deliveryStart, LocalDate deliveryEnd){
        this.deliveryWindowStart = deliveryStart;
        this.deliveryWindowEnd = deliveryEnd;

        System.out.println(String.format("Your Order will delivered some time between %s and %s", deliveryWindowStart, deliveryWindowEnd));
    }

}
