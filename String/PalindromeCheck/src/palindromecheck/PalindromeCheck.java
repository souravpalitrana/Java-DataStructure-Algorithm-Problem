/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromecheck;

/**
 * Time complexity O(n) Space Complexity O(1)
 * @author souravpalit
 */
public class PalindromeCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "abcdcba";
        //String input = "sourav";
        System.out.println(isPalindrome(input));
    }
    
    public static boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }
        
        int i = 0; int j = str.length() - 1;
        
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
}
