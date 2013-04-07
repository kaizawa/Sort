package com.cafeform.algorithm.sort;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Experimental implementation of Quick Sort
 */
public class QuickSort extends SortAlgorithm {

    AtomicInteger steps;

    public QuickSort(int[] data) {
        super(data);
    }

    /**
     * Kick sort() method.
     *
     *
     * @return SortResult
     */
    @Override
    public SortResult doSort() {
        sort(data, 0, data.length - 1);
        return new SortResult("QuickSort", data, time.intValue());
    }

    /**
     * Perform sort
     *
     * @param data
     * @param first
     * @param last
     */
    private void sort(int[] data, int first, int last) {
//        System.out.println("sort called: first: " + first + " last: " + last);
        int pivot;
        if (first < last) {
            /* 
             * get the index of pivot within data[]
             */
            pivot = partition(data, first, last);
            sort(data, first, pivot - 1);
            sort(data, pivot + 1, last);
        }
    }

    /* 
     * Partition the array usin last value as pivot.
     * 
     * Before 
     *   Index : [1][2][3][4][5][6][7]
     *   Value :  7  3  8  1  6  9  4 
     *                              ^^
     *                              pivot
     * Pickup last value as pivot.
     * Then, perform partiton.
     * Left side value of pivot must have
     * smaller value. Ana right side must
     * have large value.
     * 
     * After 
     *   Index : [1][2][3][4][5][6][7]
     *   Value :  3  1  4  7  6  9  8 
     *            ^^^^     ^^^^^^^^^^ 
     *            small        large
     */
    private int partition(int[] data, int first, int last) {
        int smallLast = first - 1;
        int pivotVal = data[last];

        for (int i = first; i < last; i++) {
            if (data[i] <= pivotVal) {
                smallLast++;                
                swapVal(smallLast, i);
                time.incrementAndGet();                
            }
            time.incrementAndGet();
        }

        int middle = smallLast + 1;
        data[last] = data[middle];
        data[middle] = pivotVal;
        time.incrementAndGet();
        return middle;
    }
}
