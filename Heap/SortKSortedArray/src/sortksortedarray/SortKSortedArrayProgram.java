/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortksortedarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(nlogk) because each time the heap will hold maximum k item
 * and siftDown will run on logk so it is O(nlogk) and Space Complexity is O(k)
 * because maximum we store k values in the heap. As we can do this in place
 * so we are not mentioning the n sorted array size. 
 * @author souravpalit
 */
public class SortKSortedArrayProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] kSortedArray = {3, 2, 1, 0, 4, 7, 6, 5, 9, 8, 7};
        int k = 3;
        int [] sortedArray = sortKSortedArray(kSortedArray, k);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
    
    public static int [] sortKSortedArray(int [] array, int k) {
        int [] sortedArray = new int [array.length];
        List<Integer> firstKElements = new ArrayList<Integer>();
        
        for (int i = 0; i < Math.min(k + 1, array.length); i++) {
            firstKElements.add(array[i]);
        }
        
        MinHeap minHeap = new MinHeap(firstKElements);
        int indexToInsertElement = 0;
        
        for (int i = k + 1; i < array.length; i++) {
            int minElement = minHeap.remove();
            sortedArray[indexToInsertElement] = minElement;
            indexToInsertElement++;
            minHeap.insert(array[i]);
        }
        
        while (minHeap.heap.size() > 0) {
            sortedArray[indexToInsertElement] = minHeap.remove();
            indexToInsertElement++;
        }
        
        return sortedArray;
    }
    
}
