/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removekdigits;

import java.util.Stack;

/**
 * Leetcode: 402. Remove K Digits
 * Problem Link: https://leetcode.com/problems/remove-k-digits/
 * @author souravpalit
 */
public class RemoveKDigits {
    
    public static void main(String args []) {
        String num = "112";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    // TC: O(N) SC: O(N) where N is the length of the string
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            
            stack.add(digit);
        }
        
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        
        StringBuilder builder = new StringBuilder();
        
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        
        builder.reverse();
        boolean isLeadingZeroRemoved = false;
        
        while (builder.length() > 0 && !isLeadingZeroRemoved) {
            if (builder.charAt(0) != '0') {
                isLeadingZeroRemoved = true;
                break;
            }
            builder.deleteCharAt(0);
        }
        
        return builder.length() > 0 ? builder.toString() : "0";
    }
}
