package com.epam.java.se;

import java.util.Arrays;

/**
 * Created by Мария on 07.02.2017.
 */
public class MergeSort {
        private int[] data;
        private int size;

        public MergeSort(int[] data) {
            this.data = Arrays.copyOf(data, data.length);
            size = data.length;
        }

        public MergeSort() {
            data = new int[10];
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public void sort(){
            mergeSort(data, 0, getSize(), new int[getSize()]);
            for (int i=0; i<data.length; i++){
                System.out.println(data[i]);
            }

        }

        private static void mergeSort(int[] data, int startInclusive, int endExclusive, int[] free) {
            final int length = endExclusive;
            if (length <= 1) {
                return;
            }
            for (int i = 1; i < length; i = i + i){
                for (int j = 0; j < length-i; j += i + i) {
                    merger(data, j, j + i - 1, Math.min(j + i + i - 1, length - 1), free);
                }
            }
        }

        private static void merger(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
            free = Arrays.copyOf(data, data.length);

            int i = startInclusive, j = mid + 1;
            for (int k = startInclusive; k <= endExclusive; k++) {
                if (i > mid) data[k] = free[j++];
                else if (j > endExclusive) data[k] = free[i++];
                else if (free[j] < free[i]) data[k] = free[j++];
                else data[k] = free[i++];
            }
        }

}

