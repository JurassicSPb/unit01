package com.epam.java.se;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by Мария on 18.02.2017.
 */

public class IntArrayList {
    private int[] data;
    private int size;

    public IntArrayList(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
        size = data.length;
    }

    public IntArrayList() {
        data = new int[10];
        size = 0;
    }

    public void add(int value) {
        ensureCapasity(size + 1);
        data[size] = value;
        size += 1;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[i];
    }

    public int getSize() {
        return size;
    }

    public int maxValueInefficient() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return maxValueRec(data, 0, size);
    }

    private int maxValueRec(int[] data, int startInclusive, int endExlusive) {
        final int length = endExlusive - startInclusive;

        if (length == 1) {
            return data[startInclusive];
        } else if (length == 0) {
            return Integer.MIN_VALUE;
        }

        final int mid = startInclusive + length/2;
        return Math.max(
                maxValueRec(data, startInclusive, mid),
                maxValueRec(data, mid, endExlusive)
        );
    }

    public void sortDescending(){
        mergeSortDescending(data, 0, getSize(), new int[getSize()]);
    }

    public void sortAscending(){
        mergeSortAscending(data, 0, getSize(), new int[getSize()]);
    }
    /**
     * Recursive method, expects collection to be sorted
     *
     * @param target value to find in collection
     * @return index of the value or -indexToInsert - 1
     */
    public int binarySearchRecursive(int target){
        return binarySearchRecursive(data, 0, data.length-1, target);
    }

    public int binarySearchRecursive(int [] data, int start, int end, int target){
        int middle = start + (end - start) / 2;
        if (end < start){
            return  -start-1;
        }
        if (target==data[middle]){
            return middle;
        }
        else if (target<data[middle]){
            return binarySearchRecursive(data, start, middle-1, target);
        }
        else{
            return binarySearchRecursive(data, middle+1, end, target);
        }
    }

    /**
     * Loop method, expects collection to be sorted
     *
     * @param target value to find in collection
     * @return index of the value or -indexToInsert - 1
     */
    public int binarySearchLoop(int target){
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
        return -start-1;
    }

    private static void mergeSortDescending(int[] data, int startInclusive, int endExclusive, int[] free) {
        final int length = endExclusive - startInclusive;
        if (length <= 1) {
            return;
        }
        final int mid = startInclusive + length/2;

        mergeSortDescending(data, startInclusive, mid, free);
        mergeSortDescending(data, mid, endExclusive, free);

        mergerDescending(data, startInclusive, mid, endExclusive, free);
    }

    private static void mergerDescending(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid) data[k] = free[j++];
            else if (j >= endExclusive) data[k] = free[i++];
            else if (free[i] < free[j]) data[k] = free[i++];
            else data[k] = free[j++];
        }
    }

    private static void mergeSortAscending(int[] data, int startInclusive, int endExclusive, int[] free) {
        final int length = endExclusive;
        if (length <= 1) {
            return;
        }
        for (int i = 1; i < length; i = i + i){
            for (int j = 0; j < length-i; j += i + i) {
                mergerAscending(data, j, j + i - 1, Math.min(j + i + i - 1, length - 1), free);
            }
        }
    }

    private static void mergerAscending(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        free = Arrays.copyOf(data, data.length);

        int i = startInclusive, j = mid + 1;
        for (int k = startInclusive; k <= endExclusive; k++) {
            if (i > mid) data[k] = free[j++];
            else if (j > endExclusive) data[k] = free[i++];
            else if (free[j] < free[i]) data[k] = free[j++];
            else data[k] = free[i++];
        }
    }

    private void ensureCapasity(int requiredCapacity) {
        if (requiredCapacity <= getCapacity()) {
            return;
        }
        final int newCapacity = Math.max(requiredCapacity, (getCapacity() * 3) / 2 + 1);
        data = Arrays.copyOf(data, newCapacity);
    }

    private int getCapacity() {
        return data.length;
    }
}