package com.epam.java.se.tasks;

/**
 * Created by Мария on 08.02.2017.
 */
public class Task5 {

    public static int [][] getMatrix(int size){
        if(size <=0) throw new IllegalArgumentException("size must be > 0");

        int [][] matrix = new int[size][size];
        for (int i=0; i<matrix.length; i++){
            matrix[i][i] = 1;
            matrix[i][matrix.length - i - 1] = 1;
            for (int j=0; j<matrix.length; j++){
            System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        return matrix;
    }

}
