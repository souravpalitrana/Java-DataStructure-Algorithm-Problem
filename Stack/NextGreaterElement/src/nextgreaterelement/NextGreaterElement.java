/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgreaterelement;

import java.util.Arrays;
import java.util.Stack;

/**
 * Both solution: Time Complexity: O(n) Space Complexity: O(n)
 * @author souravpalit
 */
public class NextGreaterElement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = {2, 5, -3, -4, 6, 7, 2};
        int [] result = nextGreaterElementAlternate(array);
        
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    
    public static int [] nextGreaterElement(int [] array) {
        int [] result = new int [array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < result.length * 2; i++) {
            int circularIdx = i % result.length;
            
            while (!stack.isEmpty() && array[circularIdx] > array[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = array[circularIdx];
            }
            stack.push(circularIdx);
        }
        
        return result;
    }
    
    public static int [] nextGreaterElementAlternate(int [] array) {
        int [] result = new int [array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = result.length * 2 - 1; i >= 0; i--) {
            int circularIdx = i % result.length;
            
            while (!stack.isEmpty()) {
                if (array[circularIdx] < stack.peek()) {
                    result[circularIdx] = stack.peek();
                    break;
                } else {
                    // that means stack top value is small or equal so we need
                    // to pop it
                    stack.pop();
                }
            }
            stack.push(array[circularIdx]);
        }
        
        return result;
    }
    
}
