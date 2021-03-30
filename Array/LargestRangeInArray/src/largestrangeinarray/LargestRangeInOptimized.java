/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestrangeinarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity O(n) Space Complexity O(n)
 *
 * @author souravpalit
 */
public class LargestRangeInOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] input = {19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14};
        int[] output = getLargestRange(input);
        System.out.println("[" + output[0] + "," + output[1] + "]");
    }

    public static int[] getLargestRange(int[] array) {
        if (array.length == 1) {
            return new int[]{array[0], array[0]};
        }

        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], false);
        }
        int prevStart = 0;
        int prevEnd = 0;
        int prevCount = 0;
        for (int i = 0; i < array.length; i++) {
            int mid = array[i];

            if (!map.get(mid)) {
                int count = 1;
                int start = mid;
                int end = mid;
                // Left Explore
                int left = mid - 1;
                while (map.containsKey(left)) {
                    map.put(left, true);
                    start = left;
                    count++;
                    left--; 
                }

                // Right Explore
                int right = mid + 1;
                while (map.containsKey(right)) {
                    map.put(right, true);
                    end = right;
                    count++;
                    right++;
                }

                if (count > prevCount) {
                    prevCount = count;
                    prevStart = start;
                    prevEnd = end;
                }
            }

        }
        
        return new int [] {prevStart, prevEnd};
    }
}
