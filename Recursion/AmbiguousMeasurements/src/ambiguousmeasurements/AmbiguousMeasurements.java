/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambiguousmeasurements;

import java.util.HashMap;

/**
 * Time complexity: O(low * high * n) and Space Complexity: O(low * high)
 * @author souravpalit
 */
public class AmbiguousMeasurements {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] cups = new int[][]{{200, 210}, {450, 465}, {800, 850}};
        int low = 2100;
        int high = 2300;
        
        System.out.println(ambiguousMeasurements(cups, low, high));
    }

    public static boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        HashMap<String, Boolean> memorization = new HashMap<String, Boolean>();
        return canMeasureInRange(measuringCups, low, high, memorization);
    }

    public static boolean canMeasureInRange(int[][] measuringCups, int low, int high,
            HashMap<String, Boolean> memorization) {
        String memorizeKey = createHashableKey(low, high);

        if (memorization.containsKey(memorizeKey)) {
            return memorization.get(memorizeKey);
        }

        if (low <= 0 && high <= 0) {
            return false;
        }

        boolean canMeasure = false;

        for (int[] cup : measuringCups) {
            int cupLow = cup[0];
            int cupHigh = cup[1];

            if (low <= cupLow && cupHigh <= high) {
                canMeasure = true;
                break;
            }

            int newLow = Math.max(0, low - cupLow);
            int newHigh = Math.max(0, high - cupHigh);
            canMeasure = canMeasureInRange(measuringCups, newLow, newHigh, memorization);
            if (canMeasure) {
                break;
            }
        }

        memorization.put(memorizeKey, canMeasure);
        return canMeasure;
    }

    public static String createHashableKey(int low, int high) {
        return low + ":" + high;
    }

}
