/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triple.step;

/**
 * Problem Statement: A child is running up a staircase with n steps and can climb
 * either 1 step, 2 step or 3 steps at a time. Implement a method to determine how
 * many possible ways the child can run up the stairs
 * @author souravpalit
 */
public class TripleStep {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long stairCount = 37;
        
        System.out.println("Number of ways the child can run up the stairs is : " + countWays(stairCount));
    }
    
    public static long countWays(long n) {
        
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
        }
        
    }
    
}
