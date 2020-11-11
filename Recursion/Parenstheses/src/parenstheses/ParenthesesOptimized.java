/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parenstheses;

import java.util.ArrayList;
import java.util.Set;
import static parenstheses.Parenstheses.generateParen;

/**
 * Implement an algorithm to print all valid(i.e. properly opened and closed) 
 * combinations of n pairs of parentheses
 * @author souravpalit
 */
public class ParenthesesOptimized {
    
    public static void main(String[] args) {
        
        ArrayList<String> parenthese = generateParen(3);
        for (String paren : parenthese) {
            System.out.println(paren);
        }
    }
    
    public static ArrayList<String> generateParen(int count) {
        ArrayList<String> list = new ArrayList<String>();
        char [] brackets = new char [count * 2];
        addParen(list, count, count, brackets, 0);
        return list;
    }
    
    public static void addParen(ArrayList<String> list, 
            int leftRem, int rightRem, char [] brackets, int index) {
        if (leftRem < 0 || rightRem < leftRem) return; // invalid expression
        
        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(brackets));
        } else {
            brackets[index] = '(';
            addParen(list, leftRem - 1, rightRem, brackets, index + 1);
            
            brackets[index] = ')';
            addParen(list, leftRem, rightRem - 1, brackets, index + 1);
        }
        
    }
    
    
}
