/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedbrackets;

import java.util.Stack;

/**
 * Time Complexity: O(1) Space Complexity: O(n)
 * @author souravpalit
 */
public class BalancedBrackets {
    
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "([])(){}(())()()";
        // Check test Code
    }
    
    public static boolean isBalancedBrackets(String str) {
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isBracket(ch)) {
                continue;
            }
            if (stack.empty()) {
                stack.push(ch);
            } else {
                if (isLastBracketIsClosing(stack, ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static boolean isLastBracketIsClosing(Stack<Character> stack, char currentBracket) {
        if (currentBracket == '(' && stack.peek() == ')' || currentBracket == ')' && stack.peek() == '(') {
            return true;
        } else if (currentBracket == '{' && stack.peek() == '}' || currentBracket == '}' && stack.peek() == '{') {
            return true;
        } else if (currentBracket == '[' && stack.peek() == ']' || currentBracket == ']' && stack.peek() == '[') {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isBracket(char ch) {
        switch (ch) {
            case '(' :
            case ')' :
            case '{' :
            case '}' :
            case '[' :
            case ']' : return true;
            default : return false;
        }
    }
    
}
