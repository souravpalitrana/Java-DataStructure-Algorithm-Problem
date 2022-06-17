/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumcosttoconnectsticks;

import java.util.PriorityQueue;

/**
 *
 * @author souravpalit
 */
public class MinimumCostToConnectSticks {

    public static void main(String[] args) {
        int [] sticks = {10, 12, 9, 14, 13, 2, 8, 14, 15, 16};
        System.out.println(connectSticks(sticks));
    }
    
    /**
     * MinHeap to get 2 stick whose heights are smaller than others
     * TC: O(nlogn) because of insertion in the heap
     * SC: O(n) for the heap
     * @param sticks
     * @return 
     */
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.add(stick);
        }
        int cost = 0;
       
        while (minHeap.size() > 1) {
            int stick1 = minHeap.remove();
            int stick2 = minHeap.remove();
            int newStick = stick1 + stick2;
            cost += newStick;
            minHeap.add(newStick);
        }
        
        return cost;
    }
    
}
