package com.epam.java.se;

import org.junit.Test;

/**
 * Created by Мария on 07.02.2017.
 */
public class MergeSortTest {
    @Test
    public void sort(){
        int [] data = new int []{Integer.MAX_VALUE, 10, 5, 7, 1, -5, 1000, Integer.MIN_VALUE, 0};
//        int [] data = new int []{10, 5, 7};
        MergeSort mergeSort = new MergeSort(data);
        mergeSort.sort();
    }
}
