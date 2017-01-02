package com.softgroup.test.task5;

import java.io.File;
import java.util.List;

/**
 * Created by Виктор on 31.12.2016.
 */
public class Test {

    //All methods for solving the problems of employees are situated in EmployeeManager.class
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        //Adding test data
        manager.addEmployee(new FixedPriceEmployee(1, "Ivan", "Ivanov", 1000));
        manager.addEmployee(new FixedPriceEmployee(2, "Vasyl", "Troyan", 1000));
        manager.addEmployee(new FixedPriceEmployee(3, "Taras", "Boyko", 1700));
        manager.addEmployee(new FixedPriceEmployee(4, "Ivan", "Petrov", 2000));

        manager.addEmployee(new HourlyWageEmployee(5, "Inna", "Melnyk", 20));
        manager.addEmployee(new HourlyWageEmployee(6, "Petro", "Shishkin", 28));
        manager.addEmployee(new HourlyWageEmployee(7, "Pavlo", "Kravchuk", 20));
        manager.addEmployee(new HourlyWageEmployee(8, "Vasyl", "Krivcev", 15));

        //a - Sorting and printing the list of employees
        System.out.println("Sorted employees:");
        manager.sortList();
        manager.printList();
        System.out.println();

        //b - Printing top 5 employees
        System.out.println("Top  5 employees:");
        manager.printTopEmployees(5);
        System.out.println();

        //c - Printing the id of 3 last employees
        System.out.println("Id of 3 last employees:");
        List<Employee> employees = manager.getEmployeeList();
        for(int i = employees.size() - 3; i < employees.size(); i++){
            System.out.println(employees.get(i).getId());
        }
        System.out.println("******************");

        //d - Serializing and deserializing collection of employees
        manager.serializeList(new File("D:\\Programming\\JavaProjects\\test.dat"));
        System.out.println("List for serializing:");
        manager.printList();
        System.out.println("******************");

        EmployeeManager manager2 = new EmployeeManager();
        manager2.deserializeList(new File("D:\\Programming\\JavaProjects\\test.dat"));
        System.out.println("List after deserializing:");
        manager2.printList();
        System.out.println("******************");

        //e - Handling the incorrect format of file
        EmployeeManager manager3 = new EmployeeManager();
        manager3.deserializeList(new File("D:\\Programming\\JavaProjects\\mytest.dat"));
    }
}
