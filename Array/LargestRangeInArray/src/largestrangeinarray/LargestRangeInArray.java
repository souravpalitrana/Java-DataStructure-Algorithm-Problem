/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestrangeinarray;

import java.util.Arrays;

/**
 * Time Complexity O(nlogn) Space Complexity O(1)
 * @author souravpalit
 */
public class LargestRangeInArray {

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
       
        Arrays.sort(array);
        
        int count = 0;
        int start = array[0];
        int end = array[1];

        Range range = new Range();
        range.start = start;
        int dif = start + 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == dif) {
                end = array[i];
                count++;
                dif++;
                if (i == array.length - 1 && count > range.count) {
                    range.start = start;
                    range.end = end;
                    range.count = count;
                }
            } else if (array[i] == array[i - 1]) {
                // If the value is same
                if (i == array.length - 1 && count > range.count) {
                    range.start = start;
                    range.end = end;
                    range.count = count;
                }
            } else {
                if (count > range.count) {
                    range.start = start;
                    range.end = end;
                    range.count = count;
                }
                start = array[i];
                count = 0;
                dif = start + 1;
            }
        }
        
        return new int[]{range.start, range.end};
    }

    public static class Range {

        public int start;
        public int end;
        public int count = 0;
    }
}
