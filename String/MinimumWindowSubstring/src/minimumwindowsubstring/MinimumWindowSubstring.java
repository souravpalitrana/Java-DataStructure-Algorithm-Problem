/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumwindowsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode: 76. Minimum Window Substring Problem Link:
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * @author souravpalit
 */
public class MinimumWindowSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s, t));
    }

    // TC: O(m + n) where m and n is the length of s and t respectively
    // SC: O(m + n) where m and n is the length of s and t respectively
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> frequencyMapOfT = getFrequencyMap(t);
        Map<Character, Integer> windowMap = new HashMap<>();

        int windowLeftIdx = 0;
        int distinctCharRequired = frequencyMapOfT.size();
        int distinctCharFound = 0;
        int minimumWindow = Integer.MAX_VALUE;
        int minWindowStartIdx = 0;
        int minWindowEndIdx = 0;

        for (int windowRightIdx = 0; windowRightIdx < s.length(); windowRightIdx++) {
            char ch = s.charAt(windowRightIdx);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (frequencyMapOfT.containsKey(ch)
                    && frequencyMapOfT.get(ch).intValue() == windowMap.get(ch).intValue()) {
                distinctCharFound++;
            }

            if (distinctCharFound == distinctCharRequired) {

                
                
                // Reduce the window size
                while (windowLeftIdx <= windowRightIdx && distinctCharFound == distinctCharRequired) {
                    
                    if (windowRightIdx - windowLeftIdx + 1 < minimumWindow) {
                        minimumWindow = windowRightIdx - windowLeftIdx + 1;
                        minWindowStartIdx = windowLeftIdx;
                        minWindowEndIdx = windowRightIdx;
                    }
                    
                    char charToRemove = s.charAt(windowLeftIdx);
                    if (windowMap.get(charToRemove) == 1) {
                        windowMap.remove(charToRemove);
                    } else {
                        windowMap.put(charToRemove, windowMap.get(charToRemove) - 1);
                    }

                    if (frequencyMapOfT.containsKey(charToRemove)
                            && (!windowMap.containsKey(charToRemove)
                            || frequencyMapOfT.get(charToRemove).intValue() > windowMap.get(charToRemove).intValue())) {
                        distinctCharFound--;
                    }

                    windowLeftIdx++;
                }
            }
        }

        return minimumWindow == Integer.MAX_VALUE ? "" : s.substring(minWindowStartIdx, minWindowEndIdx + 1);

    }

    // TC: O(n) SC: O(n) where n is the length of the parameter
    private static Map<Character, Integer> getFrequencyMap(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        return frequencyMap;
    }

}
