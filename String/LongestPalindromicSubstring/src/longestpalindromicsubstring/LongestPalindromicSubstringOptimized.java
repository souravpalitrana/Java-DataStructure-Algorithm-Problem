/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestpalindromicsubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity O(n^2) Space Complexity O(n) because we are returning string
 * @author souravpalit
 */
public class LongestPalindromicSubstringOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "abaxyzzyxf";
        //String str = "aaacccccbb";
        System.out.println(findlongestPalindromicSubstring(str));
    }
    
    public static String findlongestPalindromicSubstring(String str) {
        int palindromCount = 0;
        int start = 0;
        int end = 1;
        
        for (int i = 1; i < str.length(); i++) {
            int oddPalindromeLength = getPalindromeLength(str, i - 1, i + 1);
            int evenPalindromeLength = getPalindromeLength(str, i - 1, i);
            
            if (oddPalindromeLength > palindromCount) {
                int mid = oddPalindromeLength / 2;
                palindromCount = oddPalindromeLength;
                start = i - mid;
                end = i + mid + 1;
            }
            
            if (evenPalindromeLength > palindromCount) {
                int mid = evenPalindromeLength / 2;
                palindromCount = evenPalindromeLength;
                start = i - mid;
                end = i + mid ;
            }
        }
        
        return str.substring(start, end);
    }
    
    public static int getPalindromeLength(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            } 
            count += 2;
            left--;
            right++;
        }
        
        return count;
    }
    
}
