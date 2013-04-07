package com.cafeform.algorithm.sort;

/**
 *
 * @author kaizawa
 */
public class SortResult {
    private final int[] data;
    private int time = Integer.MAX_VALUE;
    private String name = null;
    
    public SortResult(int[] data){
        this.data = data;
    }

    SortResult(int[] output, int time) {
        this(output);
        this.time = time;
    }
    
    SortResult(String name, int[] output, int time) {
        this(output);
        this.time = time;
        this.name = name;
    }
    
    public int[] getOutput() {
        return data;
    }
    
    public String getName(){
        return name;
    }

    public int getTime() {
        return time;
    }

    boolean verify() {
        int prevVal = Integer.MIN_VALUE;
        for(int val : data){
            if(val < prevVal){
                return false;
            }
        }
        return true;
    }   
}
