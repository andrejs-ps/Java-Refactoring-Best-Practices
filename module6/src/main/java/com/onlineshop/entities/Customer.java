package com.onlineshop.entities;

public class Customer {

    private Membership membership;
    private Address address;
    private Phone phone;
    private int age;

    public int getInternationalPhoneNumber(){
        return Integer.valueOf(
                phone.getInternationalFormat()
        );
    }


    // try to refactor this on your own
    public int getSimplePhoneNumber(){
        return Integer.valueOf(
                phone.getAreaCode() +
                phone.getNumber()
        );
    }

    public Customer(Address address){
        this.address = address;
    }

    public Customer(Address address, int age){
        this.address = address;
        this.age = age;
    }

    public Customer(Membership membership, Address address, int age){
        this.membership = membership;
        this.address = address;
        this.age = age;
    }



    public Membership getMembership() {
        return membership;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getCountry(){
        return this.getAddress().getCountry().toString();
    }
}
