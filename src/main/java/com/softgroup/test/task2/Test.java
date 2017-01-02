package com.softgroup.test.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Skapoushchenko on 30.12.2016.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        int a = 0, b = 0, n = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter a:");
            a = Integer.parseInt(reader.readLine());
            System.out.println("Enter b:");
            b = Integer.parseInt(reader.readLine());
            System.out.println("Enter n(between 1 and 20):");
            n = Integer.parseInt(reader.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Polynomial expression for a = " + a + ", b = " + b + ", n = " + n + ":");
        System.out.println(test.writePolynomialExpression(n) + test.getPolynomialResult(a, b, n));
    }

    //Writes polynomial expression for exponent n
    public String writePolynomialExpression(int n){
        StringBuilder expression = new StringBuilder();
        List<Integer> binomialCoefficients = receiveCoefficients(n);
        for(int i = 0; i <= n; i++){
            if(i == 0){
                expression.append("a^").append(n).append("+");
            }else if(i == 1){
                expression.append(binomialCoefficients.get(i)).append("*").append("a^").append(n-i).append("*").append("b").append("+");
            }else if(i == n - 1){
                expression.append(binomialCoefficients.get(i)).append("*").append("a").append("*").append("b^").append(i).append("+");
            }else if(i == n){
                expression.append("b^").append(n).append("=");
            }else{
                expression.append(binomialCoefficients.get(i)).append("*").append("a^").append(n-i).append("*").append("b^").append(i).append("+");
            }
        }
        return expression.toString();
    }

    //Returns all binomial coefficients for current exponent
    public List<Integer> receiveCoefficients(int exponent){
        List<Integer> binomialCoefficients = new ArrayList<>();
        for(int i = 0; i <= exponent; i++){
            long result = factorial(exponent)/(factorial(i) * factorial(exponent - i));
            binomialCoefficients.add((int)result);
        }
        return binomialCoefficients;
    }

    //Returns factorial for any number. It works correctly for number from 1 to 20. For other cases it's recommended
    //to use BigInteger
    public long factorial(int number){
        if(number == 0 || number == 1){
            return 1;
        }
        return number * factorial(number - 1);
    }

    //Returns the result for expression (a + b)^n
    public long getPolynomialResult(int a, int b, int n){
        List<Integer> binomialCoefficients = receiveCoefficients(n);
        long result = 0;
        for(int i = 0; i <= n; i++){
            result += binomialCoefficients.get(i) * Math.pow(a, n - i) * Math.pow(b, i);
        }
        return result;
    }
}
