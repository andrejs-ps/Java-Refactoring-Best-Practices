package com.onlineshop;


import com.onlineshop.entities.Customer;
import com.onlineshop.entities.DeliveryTimeWindow;
import com.onlineshop.entities.Order;
import com.onlineshop.handlers.CheckoutHandler;
import com.onlineshop.items.Cheese;
import com.onlineshop.items.Chocolate;
import com.onlineshop.items.Item;

import java.time.LocalDate;
import java.util.List;

import static com.onlineshop.entities.DeliveryTimeWindow.deliveryTimeWindow;
import static java.time.LocalDate.now;
import static java.util.Arrays.asList;

public class App {


    public static void main(String[] args){

        CheckoutHandler checkout = new CheckoutHandler();

        Customer customer4 = new Customer("GOLD", "MyStreet 123, US");

        // add items to list
        List<Item> shoppingList2 = asList(new Chocolate(), new Chocolate(), new Cheese());
        Order order2 = new Order(shoppingList2, "DummyVoucher");
        order2.setCustomer(customer4);


        double total2 = checkout.calculateTotal(order2);
        System.out.println(total2);

        // --------------------------------------- //

        // Data Clump
        LocalDate start = now().plusDays(1);
        LocalDate end = now().plusDays(2);
        checkout.setDeliveryTimeWindow(start, end);


        // Data Clump Removed
        DeliveryTimeWindow window = new DeliveryTimeWindow(now().plusDays(1), now().plusDays(2));
        checkout.setDeliveryTimeWindow(window);

        // final version
        window = deliveryTimeWindow().startInDays(1).endInDays(2);
        checkout.setDeliveryTimeWindow(window);
    }
}
