/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package continuousmedian;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class Heap {
    public static int MIN_HEAP = 0;
    public static int MAX_HEAP = 1;
    
    public List<Integer> heap = new ArrayList<Integer>();
    private int heapType = MIN_HEAP;
    
    public Heap(List<Integer> list) {
        heap = buildHeap(list);
    }
    
    public Heap(int heapType, List<Integer> list) {
        heap = buildHeap(list);
        this.heapType = heapType;
    }
    
    public int peek() {
        return heap.get(0);
    }
    
    public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
    }
    
    public int remove() {
        int valueToRemove = heap.get(0);
        swap(0, heap.size() - 1, heap);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return valueToRemove;
    }
    
    public int size() {
        return heap.size();
    }
    
    private List<Integer> buildHeap(List<Integer> list) {
        int parentIdx = ((list.size() -1) - 1) / 2; // (i - 1) / 2
        
        for (int currentIdx = parentIdx; currentIdx >= 0; currentIdx--) {
            siftDown(currentIdx, list.size() - 1, list);
        }
        
        return list;
    }
    
    private void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int childOneIdx = 2 * currentIdx + 1;
        
        while (childOneIdx <= endIdx) {
            int childTwoIdx = 2 * currentIdx + 2;
            int swapIdx = childOneIdx;
            
            if (childTwoIdx <= endIdx && heapCondition(childTwoIdx, childOneIdx, heap)) {
                swapIdx = childTwoIdx;
            }
            
            if (heapCondition(swapIdx, currentIdx, heap)) {
                swap(swapIdx, currentIdx, heap);
                currentIdx = swapIdx;
                childOneIdx = 2 * currentIdx + 1;
            } else {
                return;
            }
        }
    }
    
    private void siftUp(int currentIdx, List<Integer> heap) {
        int parentIdx = (currentIdx - 1) / 2;
        //heap.get(currentIdx) < heap.get(parentIdx) for min heap
        while (parentIdx >= 0 && heapCondition(currentIdx, parentIdx, heap)) { 
            swap(parentIdx, currentIdx, heap);
            currentIdx = parentIdx;
            parentIdx = (currentIdx - 1) / 2;
        }
    }
    
    private void swap(int i, int j, List<Integer> heap) {
        Integer temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    private boolean heapCondition(int i, int j, List<Integer> heap) {
        return heapType == MIN_HEAP ? heap.get(i) < heap.get(j) : heap.get(i) > heap.get(j);
    }
}
