package com.cafeform.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author kaizawa
 */
abstract class SortAlgorithm {
    protected int[] data;
    protected AtomicInteger time = new AtomicInteger(0); // time to sort
    
    public SortAlgorithm (int[] data){
        this.data = Arrays.copyOf(data, data.length);
    }
    
    public abstract SortResult doSort();
    
    public void printArray(int[] data) {
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }    
    
    /** 
     * swap value of given two indeces
     */
    protected void swapVal(int i, int j){
        int tempVal = data[i];
        data[i] = data[j];
        data[j] = tempVal;
    }    
}
