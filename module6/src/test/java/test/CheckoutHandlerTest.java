package test;


import com.onlineshop.country.France;
import com.onlineshop.country.US;
import com.onlineshop.entities.*;
import com.onlineshop.handlers.CheckoutHandler;
import com.onlineshop.items.Cheese;
import com.onlineshop.items.Chocolate;
import com.onlineshop.items.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class CheckoutHandlerTest {

    static List<Item> shoppingList = Arrays.asList(new Chocolate(), new Chocolate(), new Cheese());
    static CheckoutHandler checkout = new CheckoutHandler();
    static Voucher validVoucher = new Voucher("GIMME_DISCOUNT");
    static Voucher invalidVoucher = new Voucher("DummyVoucher");



    @Test(description = "All is good, free delivery with gold membership")
    public void calculateTotalValidVoucherGoldMembership(){
        Customer customer = new Customer(Membership.GOLD, new Address(new US()), 21);
        Order order = new Order(shoppingList,validVoucher);
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 4.27);
    }

    @Test(description = "invalid voucher")
    public void calculateTotalInValidVoucherGoldMembership(){
        Customer customer = new Customer(Membership.GOLD, new Address(new US()), 21);
        Order order = new Order(shoppingList,invalidVoucher);
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 4.5);

    }

    @Test(description = "invalid voucher, non-gold membership incurs US delivery fee")
    public void calculateTotalInValidVoucherNonGoldMembership(){
        Customer customer = new Customer(Membership.SILVER, new Address(new US()), 21);
        Order order = new Order(shoppingList,invalidVoucher);
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 9.5);
    }

    @Test(description = "invalid voucher, non-gold membership incurs Global delivery fee")
    public void calculateTotalInValidVoucherNonGoldMembershipNonUs(){
        Customer customer = new Customer(Membership.SILVER, new Address(new France()), 21);
        Order order = new Order(shoppingList,invalidVoucher);
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 14.5);
    }
}
