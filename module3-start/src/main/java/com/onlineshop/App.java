package com.onlineshop;


import com.onlineshop.entities.Customer;
import com.onlineshop.items.Cheese;
import com.onlineshop.items.Chocolate;
import com.onlineshop.items.Item;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.now;

public class App {


    public static void main(String[] args){

        // Create customer
        Customer customer1 = new Customer("GOLD", "MyStreet 123, US");
        String membership = customer1.getMembership();
        String address = customer1.getAddress();

        // add items to list
        List<Item> shoppingList = Arrays.asList(new Chocolate(), new Chocolate(), new Cheese());

        CheckoutHandler checkout = new CheckoutHandler();
        // calculate total
        double total1 = checkout.calculateTotal(shoppingList, "DummyVoucher", membership, address);
        System.out.println("Total price for goods: " + total1);


        LocalDate start = now().plusDays(1);
        LocalDate end = now().plusDays(2);

        checkout.setDeliveryTimeWindow(start, end);
    }
}
