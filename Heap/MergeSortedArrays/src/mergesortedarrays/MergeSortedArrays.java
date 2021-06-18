/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortedarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity: O(nlogn) Space Complexity: O(n) where n is the total number
 * of element. This is not the optimized solution as logn can be optimized to
 * logk where k is the number of array.
 * 
 * @author souravpalit
 */
public class MergeSortedArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        arrays.add(Arrays.asList(1, 5, 9, 21));
        arrays.add(Arrays.asList(-1, 0));
        arrays.add(Arrays.asList(-124, 81, 121));
        arrays.add(Arrays.asList(3, 6, 12, 20, 150));
        
        List<Integer> sortedList = mergeSortedArrays(arrays);
        
        for (Integer value : sortedList) {
            System.out.print(value + " ");
        } 
    }
    
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        ArrayList<Integer> heapValues = new ArrayList<Integer>();
        ArrayList<Integer> sortedArrays = new ArrayList<Integer>();
        
        for (int i = 0; i < arrays.size(); i++) {
            heapValues.addAll(arrays.get(i));
        }
        
        MinHeap minHeap = new MinHeap(heapValues);
        
        while (minHeap.heap.size() > 0) {
            sortedArrays.add(minHeap.remove());
        }
        
        return sortedArrays;
    }
}
