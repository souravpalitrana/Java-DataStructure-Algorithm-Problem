/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofwaystomakechange;

import java.util.Arrays;

/**
 * Time Complexity: O(n*m) where n is the coin length and m is the amount / min(coins)
 * Space Complexity:O(n*m) because of the cache
 * @author souravpalit
 */
public class NumberOfWaysToMakeChangeOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] denoms = {1, 5};
        int amount = 6;
        
        System.out.println("Number of ways to make change : " + getNumberOfWaysToMakeChange(denoms, amount));
    }
    
    public static int getNumberOfWaysToMakeChange(int [] denoms, int amount) {
        int [][] cache = new int [amount + 1][denoms.length];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return getNumberOfWaysToMakeChange(denoms, amount, 0, cache);
    }
    
    public static int getNumberOfWaysToMakeChange(int [] denoms, int amount, int index, int [][] cache) {
        if (index == denoms.length - 1 && amount % denoms[index] == 0 ) {
            return 1;
        } else if (index == denoms.length - 1) {
            return 0;
        } else if (cache[amount][index] != -1) {
            return cache[amount][index];
        }
        
        int ways = 0;
        int denom = denoms[index];
        for (int i = 0; i * denom  <= amount; i++) {
            int remainingAmount = amount - (i * denom);
            if (remainingAmount == 0) {
                // That means we found a way so we need to increase the count
                ways++;
            } else {
                ways += getNumberOfWaysToMakeChange(denoms, remainingAmount, index + 1, cache);
            }
        }
        cache[amount][index] = ways;
        return ways;
    }
    
}
