package com.cafeform.algorithm.sort;

/**
 * Experimental Implementaion of Heap Sort
 */
public class HeapSort extends SortAlgorithm {
    
    public HeapSort(int[] data){
        super(data);
    }

    @Override
    public SortResult doSort() {    
        // Build MAX Heap first.
        buildMaxHeap();
        
        /*
         * Replace first(=biggest) value with the last one.
         * And call maxHeapify.
         * So that we can get sorted list
         */
        for(int heapSize = data.length ; heapSize > 0 ; heapSize--){
            swapVal(0, heapSize - 1);
            time.incrementAndGet();            
            maxHeapify(0, heapSize -1);
            time.incrementAndGet();
        }
        return new SortResult("HeapSort", data, time.intValue());
    }
    
    /**
     * Convert arry to max-heap.
     */
    private void buildMaxHeap(){
        /* 
         * Loop all vertices without leaf. 
         * "data.length/2" is a number of vertices that is not a leaf.
         * It's a theory.
         */
        for(int root = data.length / 2 - 1; root > -1 ; root--) {
//            System.out.printf("root: data[%d]=%d\n", root, data[root]);
            maxHeapify(root, data.length);
            time.incrementAndGet();
        }
    }    
    
    /*
     * Rougine that makes the node max-heapify.
     * Compare value of parent and children's value.
     * And place largest value as parent.
     */
    private void maxHeapify(int root, int heapSize){
        int leftChild = getLeftChild(root);
        int rightChild = getRightChild(root);
        int largest = root;
        
//        System.out.println("maxHeapify root=" + root + " heapSize=" + heapSize);
        /* 
         * choose largest value within parent, left-child and right-child 
         */ 
        for(int child : new int[] {leftChild, rightChild}){
            if(child < heapSize && data[child] > data[largest]){
                largest = child;
            }
            time.incrementAndGet();
        }
        if(largest != root){
            /* swap parent with child which has larger value */
            swapVal(root, largest);
            time.incrementAndGet();
            /* heapify the node that was previously parent */
            maxHeapify(largest, heapSize);
        }
    }
    
    private int getLeftChild(int parent){
        return parent * 2 + 1;
    }
    
    private int getRightChild(int parent){
        return parent * 2 + 2;
    }
}
