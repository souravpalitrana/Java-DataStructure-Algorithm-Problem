/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minnumberofcoinsforchange;

import java.util.Arrays;

/**
 *
 * @author souravpalit
 */
public class MinNumberOfCoinsForChangeOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int amount = 12;
        int [] denoms = {1, 5, 10};
        
        System.out.println(getMinNumberOfCoinsToMakeChange(denoms, amount));
        
    }
    
    public static int getMinNumberOfCoinsToMakeChange(int [] denoms, int amount) {
        if (denoms.length == 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        
        int [][] cache = new int [amount + 1][denoms.length];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        int change = getMinNumberOfCoinsToMakeChange(denoms, amount, 0, cache);
        return change == 0 ? -1 : change;
    }
    
    public static int getMinNumberOfCoinsToMakeChange(int [] denoms, int amount, int index, int [][] cache) {
        if (index == denoms.length - 1 && amount % denoms[index] == 0 ) {
            return amount / denoms[index];
        } else if (index == denoms.length - 1) {
            return 0;
        } else if (cache[amount][index] != -1) {
            System.out.println("Cache Used");
            return cache[amount][index];
        }
        
        int coins = 0;
        int denom = denoms[index];
        int minCoins = 0;
        for (int i = 0; i * denom  <= amount; i++) {
            int remainingAmount = amount - (i * denom);
            if (remainingAmount == 0) {
                // That means we found a way so we need to increase the count
                coins = i;
            } else {
                int numOfCoins = getMinNumberOfCoinsToMakeChange(denoms, remainingAmount, index + 1, cache);
                if (numOfCoins != 0) {
                    coins = numOfCoins + i;
                }
            }
            
            if (coins != 0 && coins < minCoins) {
                    minCoins = coins;
                    coins = 0;
             } else if (coins != 0 && minCoins == 0) {
                 minCoins = coins;
                 coins = 0;
             }
        }
        
        cache[amount][index] = minCoins;
        
        return minCoins;
    }
    
}
