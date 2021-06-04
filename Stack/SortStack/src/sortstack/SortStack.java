/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortstack;

import java.util.ArrayList;

/**
 * Time Complexity: O(n^2) Space Complexity: O(n)
 * @author souravpalit
 */
public class SortStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer>  stack = new ArrayList<Integer>();
        stack.add(-5);
        stack.add(2);
        stack.add(-2);
        stack.add(4);
        stack.add(3);
        stack.add(1);
        
        ArrayList<Integer> sortedStack = sortStack(stack);
        
        for (Integer value : sortedStack) {
            System.out.println(value);
        }
        
    }
    
    public static ArrayList sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }
        
        int top = stack.remove(stack.size() - 1);
        sortStack(stack);
        insertInSortedOrder(stack, top);
        return stack;
    }
    
    public static void insertInSortedOrder(ArrayList<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        
        int top = stack.remove(stack.size() - 1);
        insertInSortedOrder(stack, value);
        stack.add(top);
    }
    
}
