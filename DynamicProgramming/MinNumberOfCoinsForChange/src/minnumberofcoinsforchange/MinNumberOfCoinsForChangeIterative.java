/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minnumberofcoinsforchange;

import java.util.Arrays;

/**
 * Time Complexity: O(n*m) where n is the amount and m is the denoms length
 * Space Complexity: O(n)
 * @author souravpalit
 */
public class MinNumberOfCoinsForChangeIterative {
    
    public static void main(String[] args) {
        int amount = 3;
        int [] denoms = {2, 1};
        
        System.out.println(getMinNumberOfCoinsToMakeChange(denoms, amount));
    }
    
    public static int getMinNumberOfCoinsToMakeChange(int [] denoms, int n) {
        int[] minCoins = new int[n + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0; // because for 0 amount we need 0 coins
        
        for (int denomIdx = 0; denomIdx < denoms.length; denomIdx++) {
            int denom = denoms[denomIdx];
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    int currentCoin = 0;
                    if (minCoins[amount - denom] != Integer.MAX_VALUE) {
                        currentCoin = 1 + minCoins[amount - denom];
                    } else {
                        // If we do not write this then in one case currentCoin 
                        // will remain 0 and in min function it will return 0
                        // when comparing with MAX_VALUE
                       currentCoin = minCoins[amount - denom];
                    }
                    minCoins[amount] = Math.min(currentCoin, minCoins[amount]);
                }
            }
        }
         
        return minCoins[n] != Integer.MAX_VALUE ? minCoins[n] : -1;
        
    }
}
