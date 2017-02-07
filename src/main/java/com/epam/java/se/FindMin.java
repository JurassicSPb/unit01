package com.epam.java.se;

import java.util.NoSuchElementException;

/**
 * Created by Мария on 07.02.2017.
 */
public class FindMin {
    public static void findMinNumber (int [] array){
        try {
            int min = array[0];
            for (int i = 0; i < array.length; i++) {
                if (min > array[i]) min = array[i];
            }
            System.out.println(min);
        } catch (NoSuchElementException e){
                System.out.println("Wrong element");
            }
        }
    }
