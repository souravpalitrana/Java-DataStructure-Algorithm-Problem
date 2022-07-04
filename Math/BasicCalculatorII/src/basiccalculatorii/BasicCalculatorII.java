/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basiccalculatorii;

import java.util.Stack;

/**
 * Leetcode Problem: Basic Calculator II
 * Problem Link: https://leetcode.com/problems/basic-calculator-ii/
 * @author souravpalit
 */
public class BasicCalculatorII {

    // TC: O(n) SC: O(n)
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operator = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            
            if (!Character.isDigit(ch) && 
                !Character.isWhitespace(ch) || 
                i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(currentNumber);
                } else if (operator == '-') {
                    stack.push(-currentNumber);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operator == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operator = ch;
                currentNumber = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
    
}
