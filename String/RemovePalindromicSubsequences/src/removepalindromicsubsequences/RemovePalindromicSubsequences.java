/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removepalindromicsubsequences;

/**
 *
 * @author souravpalit
 */
public class RemovePalindromicSubsequences {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String reversedString = new StringBuilder(s).reverse().toString();
        if (reversedString.equals(s)) {
            return 1;
        }
        return 2;
    }
    
}
