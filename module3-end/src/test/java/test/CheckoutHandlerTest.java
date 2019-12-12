package test;


import com.onlineshop.handlers.CheckoutHandler;
import com.onlineshop.entities.Customer;
import com.onlineshop.entities.Order;
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

    @Test(description = "All is good, free delivery with gold membership")
    public void calculateTotalValidVoucherGoldMembership(){
        Customer customer = new Customer("GOLD", "MyStreet 123, US");
        Order order = new Order(shoppingList,"GIMME_DISCOUNT");
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 4.27);
    }

    @Test(description = "invalid voucher")
    public void calculateTotalInValidVoucherGoldMembership(){
        Customer customer = new Customer("GOLD", "MyStreet 123, US");
        Order order = new Order(shoppingList,"DummyVoucher");
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 4.5);

    }

    @Test(description = "invalid voucher, non-gold membership incurs US delivery fee")
    public void calculateTotalInValidVoucherNonGoldMembership(){
        Customer customer = new Customer("SILVER", "MyStreet 123, US");
        Order order = new Order(shoppingList,"DummyVoucher");
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 9.5);
    }

    @Test(description = "invalid voucher, non-gold membership incurs Global delivery fee")
    public void calculateTotalInValidVoucherNonGoldMembershipNonUs(){
        Customer customer = new Customer("SILVER", "MyStreet 123, France");
        Order order = new Order(shoppingList,"DummyVoucher");
        order.setCustomer(customer);

        double total = checkout.calculateTotal(order);
        Assert.assertEquals(total, 14.5);
    }

}
