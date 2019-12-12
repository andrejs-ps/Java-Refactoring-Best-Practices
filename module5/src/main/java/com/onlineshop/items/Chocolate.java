package com.onlineshop.items;

public class Chocolate extends Item {
    
    public double price() {
        return 1;
    }

    @Override
    public boolean isAgeRestrictedItem() {
        return false;
    }
}
