/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubstringwithoutduplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity O(N) Space Complexity O(min(N,A)) where A is the unique character
 * in the string and is the number of characters in the string.
 * @author souravpalit
 */
public class LongestSubstringWithoutDuplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "a";
        System.out.println("Longest Substring without duplicate is : " + findLongestSubstringWithoutDuplication(str));
        
    }
    
    public static String findLongestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
        int startOfSubstringIdx = 0;
        String longestSubstring = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= startOfSubstringIdx) {
                // Consider it is duplicate
                int newStringLength = i - startOfSubstringIdx;
                if (newStringLength > longestSubstring.length()) {
                    longestSubstring = str.substring(startOfSubstringIdx, i);
                }
                
                startOfSubstringIdx = lastSeen.get(ch) + 1;
            } else if (i == str.length() - 1) {
                String newSubstring = str.substring(startOfSubstringIdx);
                if (newSubstring.length() > longestSubstring.length()) {
                    longestSubstring = newSubstring;
                }
            }
            
            lastSeen.put(ch, i);
        }
        
        return longestSubstring;
    }
    
}
