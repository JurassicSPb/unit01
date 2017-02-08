package com.epam.java.se.tasks;

/**
 * Created by Мария on 08.02.2017.
 */
public class Task2 {
    public static double findMin(double epsilon){
        double result = 1.0;
        int number = 1;
        for (int i = 1; result >= epsilon; i++) {
            number = i;
            result = 1 / Math.pow(i + 1, 2);
            System.out.println("a[" + i + "] =" + result);


        }
        System.out.println("epsilon: " + epsilon + " number: " + number);
        return result;
    }

}

