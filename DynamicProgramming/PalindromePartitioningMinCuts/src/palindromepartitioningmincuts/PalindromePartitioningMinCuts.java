/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromepartitioningmincuts;

/**
 * Time Complexity: O(n^3) Space Complexity: O(n^2)
 * @author souravpalit
 */
public class PalindromePartitioningMinCuts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "noonabbad";
        System.out.println(palindromePartitioningMinCuts(str));
    }
    
    public static int palindromePartitioningMinCuts(String str) {
        boolean [][] palindrome = new boolean [str.length()][str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                palindrome[i][j] = isPalindrome(str, i , j);
            }
        }
        
        int [] cuts = new int [str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            if (palindrome[0][i]) {
                cuts[i] = 0;
            } else {
                cuts[i] = cuts[i - 1] + 1;
                
                for (int j = 1; j < i; j++) {
                    if (palindrome[j][i] && cuts[j - 1] + 1 < cuts[i]) {
                        cuts[i] = cuts[j - 1] + 1;
                    }
                }
            }
        }
        
        return cuts[cuts.length - 1];
    }
    
    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
    
}
