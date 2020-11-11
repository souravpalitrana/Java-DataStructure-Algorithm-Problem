/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parenstheses;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to print all valid(i.e. properly opened and closed) 
 * combinations of n pairs of parentheses
 * @author souravpalit
 */
public class Parenstheses {

    /**
     * Here thee solution will produce duplicates. So we are using set to
     * remove the duplicates
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<String> parens = generateParen(3);
        
        for (String paren : parens) {
            System.out.println(paren);
        }
    }
    
    public static Set<String> generateParen(int n) {
        Set<String> set = new HashSet<String>();
        
        if (n == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParen(n - 1);
            
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(0) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                
                set.add("()" + str);
            }
        }
        
        return set;
    }
    
    public static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }
    
}
