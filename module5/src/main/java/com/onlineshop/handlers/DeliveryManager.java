package com.onlineshop.handlers;


import com.onlineshop.entities.Address;
import com.onlineshop.entities.Customer;
import com.onlineshop.entities.Membership;

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

    private boolean isEligibleForFreeDelivery(Membership membership) {
        if(membership == null){
          return false;
        }
        return "GOLD".equalsIgnoreCase(membership.name());

    }

    private boolean isUsAddress(Address address) {
        return address.getCountry().toString().contains("US");
    }



}
