package com.softgroup.test.task4;

/**
 * Created by Виктор on 31.12.2016.
 */
public class Rental {
    private int kind;
    private int days;
    private double price;

    // Other fields, constructors, get, set, etc. //
    //Here we also need to initialize double price
    public Rental(int kind, int days, double price) {
        this.kind = kind;
        this.days = days;
        this.price = price;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getBasePrice() {
        // Calculation of Price.
        // . . .
       return price;
    }

    //It's necessary to use the Single Responsibility Principle.
    //Customer can be connected with a great variety of things and actions, but we shouldn't create
    //a lot of fields and methods in class Customer. The better solution is to create some other class
    //and to move some methods and field into this class.
    private double amountFor() {
        double result;
        // Another code.
        result = days * getBasePrice();
        //Here it would be better to replace some if operators with switch
        switch (kind){
            case 1: result *= 1.5; break;
            case 2: result *= 2; break;
            case 3: result *= 2.5; break;
        }

        if (days > 7) {
            result = result*3;
        }
        // Other calculation.
        return result;
    }
    // Other methods.
}
