package com.epam.java.se;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * Created by Мария on 18.02.2017.
 */
public class IntArrayListTest {
    @Test
    public void sort() throws Exception{
        int [] data = new int []{Integer.MAX_VALUE, 10, 5, -1, 7, 1,-1, -5, 1000, Integer.MIN_VALUE, 0};
        int [] copyOfData = Arrays.copyOf(data, data.length);
        Arrays.sort(copyOfData);
        IntArrayList list = new IntArrayList(data);
        list.sortAscending();
//        list.sortDescending();

        for (int i = 0; i < copyOfData.length; i++) {
            assertEquals(copyOfData[i], list.get(i));
            System.out.println(list.get(i));
        }
    }
    @Test
    public void binarySearchRecursive(){
        int [] data = new int []{Integer.MIN_VALUE, -15001, -500, -1, 0, 1, 5, 2050, 32000, Integer.MAX_VALUE};

        IntArrayList list = new IntArrayList(data);

        assertEquals(1, list.binarySearchRecursive(-15001));
        assertEquals(3, list.binarySearchRecursive(-1));
        assertEquals(-8, list.binarySearchRecursive(500));
        assertEquals(0, list.binarySearchRecursive(Integer.MAX_VALUE+1));
        assertEquals(3, list.binarySearchRecursive(-1));
    }
    @Test
    public void binarySearchLoop(){
        int [] data = new int []{Integer.MIN_VALUE, -15001, -500, -1, 0, 1, 5, 2050, 32000, Integer.MAX_VALUE};

        IntArrayList list = new IntArrayList(data);

        assertEquals(1, list.binarySearchLoop(-15001));
        assertEquals(6, list.binarySearchLoop(5));
        assertEquals(-8, list.binarySearchLoop(500));
        assertEquals(0, list.binarySearchLoop(Integer.MAX_VALUE+1));
        assertEquals(3, list.binarySearchLoop(-1));
    }
}
