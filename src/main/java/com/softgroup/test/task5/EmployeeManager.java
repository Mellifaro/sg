package com.softgroup.test.task5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Victor Skapoushchenko on 31.12.2016.
 */
public class EmployeeManager {
    private ArrayList<Employee> employeeList;

    public EmployeeManager() {
        employeeList = new ArrayList<>();
    }

    public EmployeeManager(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    //Adds employee into list of employees
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    //Removes the employee from list
    public boolean removeEmployee(Employee employee){
        return employeeList.remove(employee);
    }

    //Serializes list of employees into file
    public void serializeList(File file){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
            outputStream.writeObject(employeeList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Deserializes list of employees from file
    public void deserializeList(File file){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
            employeeList = (ArrayList) inputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            //Handling the incorrect file and other exceptions
            System.out.println("You have probably entered the wrong path to the file.\nCorrect the path and try again ");
            e.printStackTrace();
        }
    }

    //Sorting of employees in descending order by the average monthly salary.
    //In the case of equal salary – by the name.
    public void sortList(){
        Collections.sort(employeeList, (o1, o2) -> {
            if(o1.getMonthlySalary() == o2.monthlySalary){
                return o1.getLastName().compareTo(o2.getLastName());
            }
            return Double.compare(o2.getMonthlySalary(), o1.getMonthlySalary());
        });
    }

    //Print the list of employees
    public void printList(){
        employeeList.forEach(System.out::println);
    }

    //Print top employees
    //@param amount - amount of employees.
    public void printTopEmployees(int amount) {
        for(int i = 0; i < amount; i++){
            System.out.println(employeeList.get(i));
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
