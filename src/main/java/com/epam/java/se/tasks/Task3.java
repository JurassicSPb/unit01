package com.epam.java.se.tasks;

/**
 * Created by Мария on 08.02.2017.
 */
public class Task3 {
    public static void calculateFunction (double a, double b, double h){
        if (a > b || h <= 0) {
            throw new IllegalArgumentException("Wrong input parameters");
        }
        for (double i = a; i <= b ; i+=h) {
            System.out.println(i + "\t\t" + (Math.tan(2 * i) - 3));
        }

    }
}
