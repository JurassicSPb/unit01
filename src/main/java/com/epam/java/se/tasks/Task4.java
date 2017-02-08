package com.epam.java.se.tasks;

/**
 * Created by Мария on 08.02.2017.
 */
public class Task4 {
        public static double findMax (double[] inputArray){
            if (inputArray.length < 2){
                throw new IllegalArgumentException ("Array is too short");
            }
            double result = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (result < inputArray[i] + inputArray[i+1]) {
                    result = inputArray[i] + inputArray[i+1];
                }
            }
            System.out.println(result);
            return result;
        }
    }
