/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptoprentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class MinHeap {

    List<List<Integer>> heap = new ArrayList<List<Integer>>();
    
    public MinHeap(List<List<Integer>> array) {
      heap = buildHeap(array);
    }

    // Time Complexity: O(n) as we implemented heap with siftDown. If we use
    // siftUp then it will be O(nlogn), Space Complexity: O(1)
    public List<List<Integer>> buildHeap(List<List<Integer>> array) {
      int parentIdx = ((array.size() -1) - 1) / 2;
      for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
          siftDown(currentIdx, array.size() - 1, array);
      }
      return array;
    }

    // Time Complexity: O(logn) and Space Complexity: O(1)
    public void siftDown(int currentIdx, int endIdx, List<List<Integer>> heap) {
      int childOneIdx = 2 * currentIdx + 1;
      while (childOneIdx <= endIdx) {
          int swapIdx = childOneIdx;
          int childTwoIdx = 2 * currentIdx + 2;
          if (childTwoIdx <= endIdx && heap.get(childTwoIdx).get(1) < heap.get(childOneIdx).get(1)) {
              // That means childTwoIdx is smaller
              swapIdx = childTwoIdx;
          }
          
          if (heap.get(swapIdx).get(1) < heap.get(currentIdx).get(1)) {
              swap(swapIdx, currentIdx, heap);
              currentIdx = swapIdx;
              childOneIdx = 2 * currentIdx + 1;
          } else {
              return;
          }
      }
    }

    // Time Complexity: O(logn) and Space Complexity: O(1)
    public void siftUp(int currentIdx, List<List<Integer>> heap) {
      int parentIdx = (currentIdx - 1) / 2;
      while (currentIdx >= 0 && heap.get(currentIdx).get(1) < heap.get(parentIdx).get(1)) {
          swap(currentIdx, parentIdx, heap);
          currentIdx = parentIdx;
          parentIdx = (currentIdx - 1) / 2;
      }
    }

    public List<Integer> peek() {
      return heap.get(0);
    }

    public List<Integer> remove() {
      swap(0, heap.size() - 1, heap);
      List<Integer> valueToRemove = heap.get(heap.size() - 1);
      heap.remove(heap.size() - 1);
      siftDown(0, heap.size() - 1, heap);
      return valueToRemove;
    }

    public void insert(List<Integer> value) {
      heap.add(value);
      siftUp(heap.size() - 1, heap);
    }
    
    private void swap(int i, int j, List<List<Integer>> heap) {
        List<Integer> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
