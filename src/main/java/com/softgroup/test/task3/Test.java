package com.softgroup.test.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Victor Skapoushchenko on 30.12.2016.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        String line = test.readString();
        List<Integer> list = test.receiveListOfNumbers(test.receiveListOfExpessions(line));
        System.out.println("Numbers:");
        list.forEach(System.out::println);
        Collections.sort(list);
        System.out.println("Max: " + list.get(list.size()-1));
        System.out.println("Min: " + list.get(0));
    }

    //Returns any string from console, entered by user
    public String readString() {
        String line = "";
        System.out.println("Enter the string for parsing: ");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
             line = reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }

    //This method is necessary for replacing all characters except numbers and operators with space.
    //Then it splits the string around space and delete all empty elements from array.
    //Returns the list of strings with numbers and expressions
    public List<String> receiveListOfExpessions(String line){
        line = line.replaceAll("[^0-9+-/*]", " ");
        line = line.replaceAll("\\.", " ");
        String [] arrayExpresions = line.split(" ");

        List<String> listOfExpressions = new ArrayList<>();
        for(String s : arrayExpresions){
            s = s.trim();
            if(!s.isEmpty()){
                listOfExpressions.add(s);
            }
        }
        return listOfExpressions;
    }

    //Returns list of numbers
    public List<Integer> receiveListOfNumbers(List<String> expressions){
        List<Integer> numbers = new ArrayList<>();
        for(String expression : expressions){
            Integer currentNumber = parseElement(expression);
            if(currentNumber != null){
                numbers.add(currentNumber);
            }
        }
        return numbers;
    }

    /*
    * parseElment(String element) and parseFragment(String element, String operator) are recursive methods,
    * that ivoke each other and allow to parse different arithmetic expressions. They can work with a big amount of operands and operators
    * byt they don't include working with possible variants of expressions, that contain brackets. Also they don't work with
    * operators, that stand before operand.
    *
    * Working example:
    * 2+7*9-3 = 62;    *
    * But not allowed:
    * +25;
    * *13;
    * (2+6)*3;
    * */
    private Integer parseElement(String element){
        if(element == null || element.isEmpty()){
            return null;
        }
        if(element.contains("+")){
            return parseFragment(element, "\\+");
        }
        if(element.contains("-")){
            return parseFragment(element, "-");
        }
        if(element.contains("*")){
            return parseFragment(element, "\\*");
        }
        if(element.contains("/")){
            return parseFragment(element, "/");
        }
        return Integer.valueOf(element);
    }

    private Integer parseFragment(String element, String operator){
        String [] fragments = element.split(operator);
        List<Integer> tempResults = new ArrayList<>();

        for(String fragment : fragments){
            Integer tempResult = parseElement(fragment);
            tempResults.add(tempResult);
        }

        int result = tempResults.get(0);
        for(int i = 1; i < tempResults.size(); i++){
            switch (operator){
                case "\\+": result += tempResults.get(i);break;
                case "-": result -= tempResults.get(i);break;
                case "\\*": result *= tempResults.get(i);break;
                case "/": result /= tempResults.get(i);break;
                default: throw new UnsupportedOperationException("Incorrect operation");
            }
        }
        return result;
    }
}
