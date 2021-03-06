/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coins;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels 
 * (5 cents) and pennies (1 cent) write code to calculate the number of ways of 
 * representing n cents.
 * @author souravpalit
 */
public class Coins {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(makeChange(100));
    }
    
    public static int makeChange(int n) {
        int [] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }
    
    public static int makeChange(int amount, int [] denoms, int index) {
        if (index >= denoms.length -1) return 1; // last denom
        
        int denomAmount = denoms[index];
        int ways = 0;
        
        for (int i = 0; i * denomAmount <= amount; i++) {
            int remainingAmount = amount - i * denomAmount;
            if (remainingAmount == 0) {
                ways++;
            } else {
                ways = ways + makeChange(remainingAmount, denoms, index + 1);
            }
        }
        
        return ways;
    }
    
}
