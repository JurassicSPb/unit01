package com.epam.java.se;

import java.util.Arrays;

/**
 * The class implements the array of longs, that can use every
 * bit of a long value for storing 1-bit flags. One element of
 * array can contain 64 flags.
 */
public class IntSet {

    /** Initial array*/
    private long[] data = new long[1];

    /** Default constructor*/
    public IntSet(){}

    /**
     * Constructor with parameters
     * @param data - array of data
     */
    public IntSet(long [] data)
    {
        this.data = data;
    }

    public long[] getData() {
        return data;
    }

    /**
     * Method to add values
     *
     * @see IntSet#ensureCapacity(int) -
     * if there is not enough space for storing value
     * (value>64), capacity of array increases
     *
     * @see IntSet#getIndexForBitShift(int) -
     * method for calculating value of bits needs to be shifted
     *
     * @param value - adding int number as index to array
     */
    public void add (int value) {
        if (value<0) {
            return;
        }
        ensureCapacity(value);
        long newData = data[getIndexOfMassive(value)]|(1L << getIndexForBitShift(value));
        data[getIndexOfMassive(value)] = newData;
    }

    /**
     *
     * @param value - remove from array by int number as index
     * @throws ArrayIndexOutOfBoundsException if array is empty
     */
    public void remove(int value) {
        if (value<0) {
            return;
        }
        try {
            if (contains(value)) {
                long newData = data[getIndexOfMassive(value)] ^ (1L << getIndexForBitShift(value));
                data[getIndexOfMassive(value)] = newData;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array is empty");
        }
    }

    /**
     *
     * @param value - checking if array contains value
     * @return true if after bit shifting with AND operation
     * long value !=0
     * @throws ArrayIndexOutOfBoundsException if array is empty
     */
    public boolean contains (int value){
        if (value<0) {
            return false;
        }
        try {
            long newData = data[getIndexOfMassive(value)] & (1L << getIndexForBitShift(value));
            return newData != 0;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array is empty");
            return false;
        }
    }

    /**
     * Merge values of two sets in each
     * iteration with OR operation
     * In case length of two sets is different,
     * the set which length is shorter
     * gains length of longer set
     * @param newSet - other set
     * @return result set
     */

    public IntSet union(IntSet newSet) {
        long [] newSetData = newSet.data;
        int maxLength = data.length > newSetData.length ? data.length : newSetData.length;

        if (newSetData.length<data.length){
            newSetData = Arrays.copyOf(newSetData, maxLength);
        }
        else {
            data = Arrays.copyOf(data, maxLength);
        }

        long [] resultData = new long[maxLength];
        for (int i=0; i<maxLength; i++) {
            resultData[i] = data[i] | newSetData[i];
        }
        return new IntSet(resultData);
    }

    /**
     * Seeks the common values of two sets in each
     * iteration with AND operation
     * In case length of two sets is different,
     * method shortens length that is longer
     * @param newSet - other set
     * @return result set
     */

    public IntSet  intersection(IntSet newSet) {
        long [] newSetData = newSet.data;
        int minLength = data.length < newSetData.length ? data.length : newSetData.length;

        if (newSetData.length>data.length){
            newSetData = Arrays.copyOf(newSetData, minLength);
        }
        else {
            data = Arrays.copyOf(data, minLength);
        }

        long [] resultData = new long[minLength];
        for (int i=0; i<minLength; i++) {
            resultData[i]=data[i]& newSetData[i];
        }
        return new IntSet(resultData);
    }
    /**
     * Seeks different values of two sets in each
     * iteration with XOR operation
     * In case length of two sets is different,
     * method increases length that is shorter
     * @param newSet - other set
     * @return result set
     */

    public IntSet difference(IntSet newSet) {
        long [] newSetData = newSet.data;
        int maxLength = data.length > newSetData.length ? data.length : newSetData.length;

        if (newSetData.length<data.length){
            newSetData = Arrays.copyOf(newSetData, maxLength);
        }
        else {
            data = Arrays.copyOf(data, maxLength);
        }

        long [] resultData = new long[maxLength];
        for (int i=0; i<maxLength; i++) {
            resultData[i] = data[i] ^ newSetData[i];
        }
        return new IntSet(resultData);
    }

    /**
     * @param newSet - here must be an original set
     * @return true if set a is subset of set b, false otherwise
     */
    public boolean isSubsetOf(IntSet newSet) {
        long [] newSetData = newSet.data;
        int maxLength = data.length > newSetData.length ? data.length : newSetData.length;

        if (newSetData.length<data.length){
            newSetData = Arrays.copyOf(newSetData, maxLength);
        }
        else {
            data = Arrays.copyOf(data, maxLength);
        }
        long [] bufferData = new long[maxLength];
        long [] resultData = new long[maxLength];
        for (int i=0; i<maxLength; i++) {
            bufferData[i] = newSetData[i] ^ data[i];
            resultData[i] = data[i] & bufferData[i];
            if (resultData[i]!=0){
                return false;
            }
        }
        return true;
    }

    private long getIndexForBitShift(int value) {
        if (value>63) {
            return value - 64 * (value / 64);
        }
        return value;
    }

    private int getIndexOfMassive(int value) {
        return value / 64;
    }

    private void ensureCapacity(int value) {
        if (data.length<= getIndexOfMassive(value)) {
            int dataSize = value / 64 + 1;
            long[] newData = new long[dataSize];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }
}