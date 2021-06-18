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
 *
 * @author souravpalit
 */
public class MinHeap2 {

    List<Item> heap = new ArrayList<Item>();
    
    public MinHeap2(List<Item> array) {
      heap = buildHeap(array);
    }

    MinHeap2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Time Complexity: O(n) as we implemented heap with siftDown. If we use
    // siftUp then it will be O(nlogn), Space Complexity: O(1)
    public List<Item> buildHeap(List<Item> array) {
      int parentIdx = ((array.size() -1) - 1) / 2;
      for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
          siftDown(currentIdx, array.size() - 1, array);
      }
      return array;
    }

    // Time Complexity: O(logn) and Space Complexity: O(1)
    public void siftDown(int currentIdx, int endIdx, List<Item> heap) {
      int childOneIdx = 2 * currentIdx + 1;
      while (childOneIdx <= endIdx) {
          int swapIdx = childOneIdx;
          int childTwoIdx = 2 * currentIdx + 2;
          if (childTwoIdx <= endIdx && heap.get(childTwoIdx).value < heap.get(childOneIdx).value) {
              // That means childTwoIdx is smaller
              swapIdx = childTwoIdx;
          }
          
          if (heap.get(swapIdx).value < heap.get(currentIdx).value) {
              swap(swapIdx, currentIdx, heap);
              currentIdx = swapIdx;
              childOneIdx = 2 * currentIdx + 1;
          } else {
              return;
          }
      }
    }

    // Time Complexity: O(logn) and Space Complexity: O(1)
    public void siftUp(int currentIdx, List<Item> heap) {
      int parentIdx = (currentIdx - 1) / 2;
      while (currentIdx >= 0 && heap.get(currentIdx).value < heap.get(parentIdx).value) {
          swap(currentIdx, parentIdx, heap);
          currentIdx = parentIdx;
          parentIdx = (currentIdx - 1) / 2;
      }
    }

    public Item peek() {
      return heap.get(0);
    }

    public Item remove() {
      swap(0, heap.size() - 1, heap);
      Item valueToRemove = heap.get(heap.size() - 1);
      heap.remove(heap.size() - 1);
      siftDown(0, heap.size() - 1, heap);
      return valueToRemove;
    }

    public void insert(Item value) {
      heap.add(value);
      siftUp(heap.size() - 1, heap);
    }
    
    private void swap(int i, int j, List<Item> heap) {
        Item temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
