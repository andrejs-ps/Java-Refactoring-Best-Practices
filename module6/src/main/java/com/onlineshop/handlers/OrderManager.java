package com.onlineshop.handlers;

import com.onlineshop.entities.Customer;

// Middle Man - do we need this class?
public class OrderManager {

    private DiscountManager discountManager = new DiscountManager();
    private DeliveryManager deliveryManager = new DeliveryManager();


    public double applyVoucher(String voucher, double price){
        return discountManager.applyVoucher(voucher, price);
    }

    public double addDeliveryFee(Customer customer, double total){
        return deliveryManager.addDeliveryFee(customer, total);
    }
}
