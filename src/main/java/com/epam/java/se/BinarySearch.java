package com.epam.java.se;

/**
 * Created by Мария on 05.02.2017.
 */
public class BinarySearch {
    public int binarySearchRecursive(int [] data, int target){
        return binarySearchRecursive(data, 0, data.length-1, target);
    }
    public int binarySearchRecursive(int [] data, int start, int end, int target){
        int middle = start + (end - start) / 2;
        if (end < start){
            return  -1;
        }
        if (target==data[middle] ){
                return middle;
        }
        else if (target<data[middle]){
            return binarySearchRecursive(data, start, middle-1, target);
        }
        else{
            return binarySearchRecursive(data, middle+1, end, target);
        }
    }
    public int binarySearchLoop(int [] data, int target){
        int start=0;
        int end = data.length-1;
        while (start<=end){
            int middle = start + (end - start) / 2;
            if (target<data[middle]){
                end = middle -1;
            }
            else if (target>data[middle]){
                start=middle+1;
            }
            else{
                return middle;
            }
        }
        return  -1;
    }
}
