/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.util.Stack;

/**
 * TowerOfHanoi classic problem
 * @author souravpalit
 */
public class TowerOfHanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // To make the variable name similar to tower we use A,B,C 
        // instead of a,b,c.
        Stack<Integer> A = new Stack<Integer>();
        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);
        
        printStack(towerOfHanoi(A.size(), A, new Stack<Integer>(), new Stack<Integer>()));
    }
    
    private static Stack<Integer> towerOfHanoi(int n, Stack<Integer> A, 
            Stack<Integer> C, Stack<Integer> B) {
        if (n == 1) {
            C.push(A.pop());
            return C;
        } 
        
        towerOfHanoi(n-1, A, B, C);
        C.push(A.pop());
        towerOfHanoi(n-1, B, C, A);
        
        return C;
    }
    
    private static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
