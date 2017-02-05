package com.epam.java.se;

import org.junit.Test;

/**
 * Created by Мария on 05.02.2017.
 */
public class BinarySearchTest {
    @Test
    public void binarySearchRecursive(){
        BinarySearch binary = new BinarySearch();
        int [] data = {4, 5, 8, 15, 96, 150, 220};
        System.out.println(binary.binarySearchRecursive(data, 5));
    }
    @Test
    public void binarySearchLoop(){
        BinarySearch binary = new BinarySearch();
        int [] data = {4, 5, 8, 15, 96, 150, 220};
        System.out.println(binary.binarySearchLoop(data, 150));
    }
}
