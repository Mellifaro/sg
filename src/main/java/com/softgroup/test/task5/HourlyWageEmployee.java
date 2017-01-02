package com.softgroup.test.task5;

/**
 * Created by Victor Skapoushchenko on 31.12.2016.
 */
public class HourlyWageEmployee extends Employee {
    private double hourlyRate;

    public HourlyWageEmployee(int id, String name, String surname, double hourlyRate) {
        super(id, name, surname);
        this.hourlyRate = hourlyRate;
        //It's necessary to initialize monthlySalary in constructor
        calculateMonthlySalary();
    }

    @Override
    public void calculateMonthlySalary() {
        super.monthlySalary = 20.8 * 8 * hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
