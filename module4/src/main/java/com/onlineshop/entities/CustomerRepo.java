package com.onlineshop.entities;

import com.onlineshop.country.Canada;
import com.onlineshop.country.France;
import com.onlineshop.country.US;

public class CustomerRepo {

    public static Customer getUsCustomer(){
        return new Customer(new Address(new US()),21);
    }

    public static Customer getUsUnderAgeCustomer(){
        return new Customer(new Address(new US()), 17);
    }

    public static Customer getFrenchCustomer(){
        return new Customer(new Address(new France()), 18);
    }

    public static Customer getFrenchUnderageCustomer(){
        return new Customer(new Address(new France()), 17);
    }

    public static Customer getCanadianCustomer(){
        return new Customer(new Address(new Canada()),18);
    }
}
