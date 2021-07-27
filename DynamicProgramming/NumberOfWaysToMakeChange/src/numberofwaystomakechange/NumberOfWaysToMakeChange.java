/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofwaystomakechange;

/**
 * Time Complexity: O(n^m) where n is the coin length and m is the amount / min(coins)
 * Space Complexity:O(n) because of call stack
 * @author souravpalit
 */
public class NumberOfWaysToMakeChange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] denoms = {1, 5};
        int amount = 6;
        
        System.out.println("Number of ways to make change : " + getNumberOfWaysToMakeChange(denoms, amount));
    }
    
    public static int getNumberOfWaysToMakeChange(int [] denoms, int amount) {
        return getNumberOfWaysToMakeChange(denoms, amount, 0);
    }
    
    public static int getNumberOfWaysToMakeChange(int [] denoms, int amount, int index) {
        if (index == denoms.length - 1 && amount % denoms[index] == 0 ) {
            return 1;
        } else if (index == denoms.length - 1) {
            return 0;
        }
        
        int ways = 0;
        int denom = denoms[index];
        for (int i = 0; i * denom  <= amount; i++) {
            int remainingAmount = amount - (i * denom);
            if (remainingAmount == 0) {
                // That means we found a way so we need to increase the count
                ways++;
            } else {
                ways += getNumberOfWaysToMakeChange(denoms, remainingAmount, index + 1);
            }
        }
        
        return ways;
    }
    
}
