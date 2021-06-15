/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptoprentals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Time Complexity: O(nlogn) and Space Complexity O(n)
 * @author souravpalit
 */
public class LaptopRentals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> times = new ArrayList<ArrayList<Integer>>();
        times.add(getInterval(0, 2));
        times.add(getInterval(1, 4));
        times.add(getInterval(4, 6));
        times.add(getInterval(0, 4));
        times.add(getInterval(7, 8));
        times.add(getInterval(9, 11));
        times.add(getInterval(3, 10));

        System.out.println("Laptop required : " + calculateRequiredLaptops(times));
    }

    public static int calculateRequiredLaptops(ArrayList<ArrayList<Integer>> times) {
        if (times.size() == 0) {
            return 0;
        }

        Collections.sort(times, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> first, ArrayList<Integer> second) {
                return Integer.compare(first.get(0), second.get(0));
            }
        });

        List<List<Integer>> heapValues = new ArrayList<List<Integer>>();
        heapValues.add(times.get(0));
        MinHeap minHeap = new MinHeap(heapValues);

        for (int i = 1; i < times.size(); i++) {
            if (times.get(i).get(0) >= minHeap.peek().get(1)) {
                minHeap.remove();
            }
            minHeap.insert(times.get(i));
        }

        return minHeap.heap.size();
    }

    public static ArrayList<Integer> getInterval(int start, int end) {
        ArrayList<Integer> interval = new ArrayList<Integer>();
        interval.add(start);
        interval.add(end);
        return interval;
    }

}
