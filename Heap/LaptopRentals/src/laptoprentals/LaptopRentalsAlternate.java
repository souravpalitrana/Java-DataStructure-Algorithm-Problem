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
public class LaptopRentalsAlternate {

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
        
        List<Integer> start = new ArrayList<Integer>();
        List<Integer> end = new ArrayList<Integer>();
        
        for (int i = 0; i < times.size(); i++) {
            start.add(times.get(i).get(0));
            end.add(times.get(i).get(1));
        }
        
        Collections.sort(start);
        Collections.sort(end);
        
        int laptopsRequired = 0;
        int startIdx = 0;
        int endIdx = 0;
        
        while (startIdx < times.size()) {
            // If start time is after end time that means we can use previous one
            if (start.get(startIdx) >= end.get(endIdx)) {
                endIdx++;
            } else {
                laptopsRequired++;
            }
            
            startIdx++;
        }
        
        return laptopsRequired;
    }

    public static ArrayList<Integer> getInterval(int start, int end) {
        ArrayList<Integer> interval = new ArrayList<Integer>();
        interval.add(start);
        interval.add(end);
        return interval;
    }
}
