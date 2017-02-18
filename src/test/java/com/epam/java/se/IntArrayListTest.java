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
        int [] data = new int []{-5, Integer.MAX_VALUE, 10, 5, 7, 0, 1, 1, -5, 1000, Integer.MIN_VALUE, -5, 0};
        Arrays.sort(data);

        IntArrayList list = new IntArrayList(data);
        assertEquals(4, list.binarySearchRecursive(0));

    }
}
