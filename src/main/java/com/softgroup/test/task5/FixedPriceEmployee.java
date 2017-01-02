package com.softgroup.test.task5;

/**
 * Created by Виктор on 31.12.2016.
 */
public class FixedPriceEmployee extends Employee {
    private double fixedMonthlyPayment;

    public FixedPriceEmployee(int id, String name, String surname, double fixedMonthlyPayment) {
        super(id, name, surname);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
        //It's necessary to initialize monthlySalary in constructor
        calculateMonthlySalary();
    }

    @Override
    public void calculateMonthlySalary() {
        super.monthlySalary = fixedMonthlyPayment;
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    public void setFixedMonthlyPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }
}
