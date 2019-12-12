package com.onlineshop.handlers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountManager {


    public double applyVoucher(String voucher, double price) {
        // check if voucher is valid
        if(isValidVoucher(voucher)){
            price = BigDecimal.valueOf(price * 0.95).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        } else {
            System.out.println("Voucher invalid");
        }

        return price;
    }

    private boolean isValidVoucher(String voucher) {
        return voucher.equals("GIMME_DISCOUNT") || voucher.equals("CHEAPER_PLEASE");
    }





}
