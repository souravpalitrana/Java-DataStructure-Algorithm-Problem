/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromicsubstrings;

/**
 *
 * @author souravpalit
 */
public class PalindromicSubstrings {

    // Time complexity: O(n^2) where n is the length of the string and
    // Space Complexity: O(n^2)
    public int countSubstrings(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        //int length = s.length();
        int palindromeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    palindrome[i][j] = true;
                    palindromeCount++;
                }
            }
        }

        for (int length = 2; length < s.length() + 1; length++) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                int j = i + length - 1;
                boolean isPalindrom = false;
                
                if (length == 2) {
                    isPalindrom = (s.charAt(i) == s.charAt(j));
                } else {
                    isPalindrom = (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1]);
                }
                
                palindrome[i][j] = isPalindrom;
                
                if (isPalindrom) {
                    palindromeCount++;
                }
            }
        }

        return palindromeCount;

    }
}
