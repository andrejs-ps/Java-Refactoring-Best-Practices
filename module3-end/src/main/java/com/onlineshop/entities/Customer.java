package com.onlineshop.entities;

public class Customer {

    private String membership;
    private String address;

    public Customer(){}

    public Customer(String membership, String address){
        this.membership = membership;
        this.address = address;
    }

    public String getMembership() {
        return membership;
    }

    public String getAddress() {
        return address;
    }
}
