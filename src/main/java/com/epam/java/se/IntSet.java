package com.epam.java.se;

import java.util.Arrays;

/**
 * Created by Мария on 01.02.2017.
 */
public class IntSet {
    private long[] data = new long[1];

    public IntSet(){}

    public IntSet(long [] data)
    {
        this.data = data;
    }

    public long[] getData() {
        return data;
    }
    public void add (int value) {
        if (value<0) {
            return;
        }
        ensureCapacity(value);
        long newData = data[getIndexOfMassive(value)]|(1L << getIndexForBitShift(value));
        data[getIndexOfMassive(value)] = newData;
    }

    public void remove(int value) {
        if (value<0) {
            return;
        }
        try {
            long newData = data[getIndexOfMassive(value)] ^ (1L << getIndexForBitShift(value));
            data[getIndexOfMassive(value)] = newData;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array is empty");
        }
    }

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

    public IntSet union(IntSet newSet) {
        long [] newSetData = newSet.data;
        int maxLength = data.length > newSetData.length ? data.length : newSetData.length;

        if (newSetData.length<data.length){
            long [] newSetDataBuffer = Arrays.copyOf(newSetData, maxLength);
            newSetData = newSetDataBuffer;
        }
        else if (data.length<newSetData.length){
            long [] originalSetDataBuffer = Arrays.copyOf(data, maxLength);
            data = originalSetDataBuffer;
        }

        long [] resultData = new long[maxLength];
        for (int i=0; i<maxLength; i++) {
            resultData[i] = data[i] | newSetData[i];
        }
        return new IntSet(resultData);
    }

    public IntSet  intersection(IntSet newSet) {
        long [] newSetData = newSet.data;
        int minLength = data.length < newSetData.length ? data.length : newSetData.length;

        if (newSetData.length>data.length){
            long [] newSetDataBuffer = Arrays.copyOf(newSetData, minLength);
            newSetData = newSetDataBuffer;
        }
        else if (data.length>newSetData.length){
            long [] originalSetDataBuffer = Arrays.copyOf(data, minLength);
            data = originalSetDataBuffer;
        }

        long [] resultData = new long[minLength];
        for (int i=0; i<minLength; i++) {
            resultData[i]=data[i]& newSetData[i];
        }
        return new IntSet(resultData);
    }

    public IntSet difference(IntSet newSet) {
        long [] newSetData = newSet.data;
        int maxLength = data.length > newSetData.length ? data.length : newSetData.length;

        if (newSetData.length<data.length){
            long [] newSetDataBuffer = Arrays.copyOf(newSetData, maxLength);
            newSetData = newSetDataBuffer;
        }
        else if (data.length<newSetData.length){
            long [] originalSetDataBuffer = Arrays.copyOf(data, maxLength);
            data = originalSetDataBuffer;
        }

        long [] resultData = new long[maxLength];
        for (int i=0; i<maxLength; i++) {
            resultData[i] = data[i] ^ newSetData[i];
        }
        return new IntSet(resultData);
    }

    public boolean isSubsetOf(IntSet newSet) {
        long [] newSetData = newSet.data;
        int maxLength = data.length > newSetData.length ? data.length : newSetData.length;

        if (newSetData.length<data.length){
            long [] newSetDataBuffer = Arrays.copyOf(newSetData, maxLength);
            newSetData = newSetDataBuffer;
        }
        else if (data.length<newSetData.length){
            long [] originalSetDataBuffer = Arrays.copyOf(data, maxLength);
            data = originalSetDataBuffer;
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