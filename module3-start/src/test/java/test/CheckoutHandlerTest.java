package test;


import com.onlineshop.CheckoutHandler;
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

        double total = checkout.calculateTotal(shoppingList, "GIMME_DISCOUNT", "GOLD", "MyStreet 123, US");
        Assert.assertEquals(total, 4.27);
    }

    @Test(description = "invalid voucher")
    public void calculateTotalInValidVoucherGoldMembership(){

        double total = checkout.calculateTotal(shoppingList, "DummyVoucher", "GOLD", "MyStreet 123, US");
        Assert.assertEquals(total, 4.5);

    }

    @Test(description = "invalid voucher, non-gold membership incurs US delivery fee")
    public void calculateTotalInValidVoucherNonGoldMembership(){
        double total = checkout.calculateTotal(shoppingList, "DummyVoucher", "SILVER", "MyStreet 123, US");
        Assert.assertEquals(total, 9.5);
    }

    @Test(description = "invalid voucher, non-gold membership incurs Global delivery fee")
    public void calculateTotalInValidVoucherNonGoldMembershipNonUs(){
        double total = checkout.calculateTotal(shoppingList, "DummyVoucher", "SILVER", "MyStreet 123, France");
        Assert.assertEquals(total, 14.5);
    }

}
