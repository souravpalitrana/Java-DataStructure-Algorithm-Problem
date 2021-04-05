/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeoverlappingintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Time Complexity O(nlogn) Space Complexity O(n)
 * @author souravpalit
 */
public class MergeOverlappingIntervals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int [][] intervals = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        //int [][] intervals = {{100, 105}, {1, 104}}; 
        //int [][] intervals = { {89, 90}, {-10, 20}, {-50, 0}, {70, 90}, {90, 91}, {90, 95}};
        int [][] intervals = { {43, 49}, {9, 12}, {12, 54}, {45, 90}, {91, 93}};
        int [][] mergedIntervals = mergeOverlappingIntervals(intervals);
        
        for (int i = 0; i < mergedIntervals.length; i++) {
            System.out.print("{" + mergedIntervals[i][0] + "," + mergedIntervals[i][1] + "} ");
        }
    }
    
    public static int [][] mergeOverlappingIntervals(int [][] intervals) {
        List<int []> mergedIntervals = new ArrayList<int []>();
        int [][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return Integer.compare(first[0], second[0]);
            }
        });
        
        int [] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval);
        
        for (int [] nextInterval : sortedIntervals) {
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];
            
            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
            
        }
        
        return mergedIntervals.toArray(new int [mergedIntervals.size()][]);
    }
    
}
