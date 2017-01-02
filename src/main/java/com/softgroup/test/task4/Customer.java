package com.softgroup.test.task4;

/**
 * Created by Victor Skapoushchenko on 31.12.2016.
 */
//It's necessary to create a new field Rental rental. Rental is a property of Customer.
//This property allows to receive all information about rent for current customer
public class Customer {
    private String name;
    private Rental rental;

    // Other fields, constructors, get, set, etc. //
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
    // Other methods.
}