/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestvalidparentheses;

import java.util.Stack;

/**
 * Time Complexity : O(n) Space Complexity: O(n)
 *
 * @author souravpalit
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }

        Stack<Pair> stack = new Stack<Pair>();
        boolean[] validPositions = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && ch == ')') {
                Pair prev = stack.peek();
                if (prev.value == '(') {
                    validPositions[prev.key] = true;
                    validPositions[i] = true;
                    stack.pop();
                }
            } else {
                stack.push(new Pair(i, ch));
            }

        }

        int maxValidLength = 0;
        int currentValidLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (validPositions[i]) {
                currentValidLength++;
            } else {
                maxValidLength = Math.max(maxValidLength, currentValidLength);
                currentValidLength = 0;
            }
        }

        maxValidLength = Math.max(maxValidLength, currentValidLength);

        return maxValidLength;
    }

    class Pair {

        int key;
        char value;

        public Pair(int key, char value) {
            this.key = key;
            this.value = value;
        }
    }

}
