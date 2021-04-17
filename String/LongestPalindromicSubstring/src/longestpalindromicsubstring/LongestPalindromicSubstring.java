/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestpalindromicsubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity O(n^3) Space Complexity O(n)
 * @author souravpalit
 */
public class LongestPalindromicSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String str = "abaxyzzyxf";
        String str = "abacccc";
        System.out.println(findlongestPalindromicSubstring(str));
    }
    
    public static String findlongestPalindromicSubstring(String str) {
        List<String> palindroms = new ArrayList<String>();
        
        for (int i = 0; i < str.length(); i++) {
            
            for (int j = str.length() - 1; j >= i; j--) {
                if (isPalindrome(str, i, j)) {
                    palindroms.add(str.substring(i, j + 1));
                }
            }
        }
        
        String maxPalindrome = "";
        
        for (String palindrome : palindroms) {
            if (palindrome.length() > maxPalindrome.length()) {
                maxPalindrome = palindrome;
            }
        }
        
        return maxPalindrome;
    }
    
    public static boolean isPalindrome(String str, int start, int end)  {
        if (str.length() == 1) return true;
        
        while(start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
    
}
