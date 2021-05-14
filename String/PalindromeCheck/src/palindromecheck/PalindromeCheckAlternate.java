/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromecheck;

/**
 * Time complexity O(n) Space Complexity O(n) because of reverse string
 * @author souravpalit
 */
public class PalindromeCheckAlternate {

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
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }
        
        String reversedString = builder.toString();
        
        return str.equals(reversedString);
    }
    
}
