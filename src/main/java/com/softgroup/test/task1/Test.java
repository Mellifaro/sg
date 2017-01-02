package com.softgroup.test.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Виктор on 29.12.2016.
 */
public class Test {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Test test = new Test();

        int lineNumber = test.readValue();
        test.printLine(lineNumber);
    }

    //Returns factorial for any number. It works correctly for number from 1 to 20. For other cases it's recommended
    //to use BigInteger
    public long factorial(int number){
        if(number == 0 || number == 1){
            return 1;
        }
        return number * factorial(number - 1);
    }

    //Method for reading exponent from console. Allows user to enter any integer value
    //between 1 and 20
    public int readValue(){
        int lineNumber = 0;
        do{
            System.out.println("Enter the line number of Pascal's triangle (between 1 and 20):");
            try {
                lineNumber = Integer.valueOf(reader.readLine());
                if(lineNumber < 1 || lineNumber > 20){
                    System.out.println("You entered the wrong data. Please, try again.");
                }
            }catch (IOException | NumberFormatException e){
                System.out.println("You entered the wrong data. Please, try again.");
            }
        }while(lineNumber < 1 || lineNumber > 20);
        return lineNumber;
    }

    //Print all binomial coefficients from the Pascal's triangle
    public void printLine(int lineNumber){
        for(int i = 0; i <= lineNumber; i++){
            long result = factorial(lineNumber)/(factorial(i) * factorial(lineNumber - i));
            System.out.print(result + " ");
        }
    }
}
