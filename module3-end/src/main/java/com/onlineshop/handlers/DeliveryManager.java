package com.onlineshop.handlers;


import com.onlineshop.entities.Customer;

public class DeliveryManager {


    public double addDeliveryFee(Customer customer, double total) {
        // handle delivery fee
        if(!isEligibleForFreeDelivery(customer.getMembership())){
            if(isUsAddress(customer.getAddress())){
                System.out.println("Adding flat delivery fee of 5 USD");
                total = total + 5;
            } else {
                System.out.println("Adding flat global delivery fee of 10 USD");
                total = total + 10;
            }
        }

        return total;
    }

    private boolean isEligibleForFreeDelivery(String membership) {
        return membership.equalsIgnoreCase("GOLD");
    }

    private boolean isUsAddress(String address) {
        return address.contains("US");
    }



}
