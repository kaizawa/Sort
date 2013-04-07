
package com.cafeform.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Test Sort Algorithms
 * 
 * @author kaizawa
 */
public class SortMain 
{
    private static final int [] data = 
    {2, 18, 37, 1, 4, 3, 5, 6, 3, 10, 22,
        44, 23, 7, 88, 3, 33, 7, 89, 65, 14};

    public static void main(String[] args) {
        new SortMain().doIt();
    }
    
    public void doIt(){
        
        List<SortResult> results = new ArrayList<>();
        results.add(new QuickSort(data).doSort());
        results.add(new HeapSort(data).doSort());

       printOriginalData();
       for(SortResult result : results){
           printResult(result);
       }
    }
    
    private void printOriginalData(){
        System.out.print("Original Data\t\t\t");
        printData(data);
        System.out.println("");        
    }
    
    private void printData(int[] dataArray){
        for(int num : dataArray){
            System.out.print(num + " ");
        }
    }

    public void printResult(SortResult result)
    {
        System.out.print(result.getName() + "\t[Cost:" + result.getTime() + "]\t");
        printData(result.getOutput());
        System.out.println(result.verify() ? "OK": "BAD");
    }
}
