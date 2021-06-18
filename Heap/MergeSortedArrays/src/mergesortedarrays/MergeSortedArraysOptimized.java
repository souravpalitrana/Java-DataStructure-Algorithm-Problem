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
 * Time complexity: O(nlogk + k) where k is for initializing heap
 * Space Complexity: O(n + K) where n is the total number
 * of element and k is the number of array
 * 
 * @author souravpalit
 */
public class MergeSortedArraysOptimized {

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
    
    // Time Complexity: O(nlogn) ans space complexity: O(n) where n is the
    // total number of elements
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        ArrayList<Item> heapValues = new ArrayList<Item>();
        ArrayList<Integer> sortedArrays = new ArrayList<Integer>();
        int [] arrayIdx = new int [arrays.size()]; 
        
        for (int i = 0; i < arrays.size(); i++) {
            heapValues.add(new Item(arrays.get(i).get(0), i));
            arrayIdx[i] = 0;
        }
        
        MinHeap2 minHeap = new MinHeap2(heapValues);
        
        while (minHeap.heap.size() > 0) {
            Item smallestElement = minHeap.remove();
            sortedArrays.add(smallestElement.value);
            
            if (arrayIdx[smallestElement.arrayIdx] == arrays.get(smallestElement.arrayIdx).size() - 1) {
                // That means for this array we reached the last position. So no 
                // need to go further in this array
                continue;
            }
            
            arrayIdx[smallestElement.arrayIdx]++;
            minHeap.insert(
                    new Item(arrays
                            .get(smallestElement.arrayIdx)
                            .get(arrayIdx[smallestElement.arrayIdx]),
                            smallestElement.arrayIdx)
            );
        }
        
        return sortedArrays;
    }
}
