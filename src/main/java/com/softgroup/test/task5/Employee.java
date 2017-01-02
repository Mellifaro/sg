package com.softgroup.test.task5;

import java.io.Serializable;

/**
 * Created by Victor Skapoushchenko on 31.12.2016.
 */
//Abstract class that contains common features of FixedPriceEmployee and HourlyWageEmployee
public abstract class Employee implements Serializable{
    protected int id;
    protected String firstName;
    protected String lastName;
    protected double monthlySalary;

    public Employee(){
    }

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Abstract method. Implemented in the inherited classes.
    public abstract void calculateMonthlySalary();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return id + "  " + lastName + " " + firstName + "  " + monthlySalary;
    }
}
