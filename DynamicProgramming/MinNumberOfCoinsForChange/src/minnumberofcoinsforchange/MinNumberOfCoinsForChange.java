/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minnumberofcoinsforchange;

/**
 *
 * @author souravpalit
 */
public class MinNumberOfCoinsForChange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int amount = 12;
        int [] denoms = {6, 2 };
        
        System.out.println(getMinNumberOfCoinsToMakeChange(denoms, amount));
        
    }
    
    public static int getMinNumberOfCoinsToMakeChange(int [] denoms, int amount) {
        if (denoms.length == 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int change = getMinNumberOfCoinsToMakeChange(denoms, amount, 0);
        return change == 0 ? -1 : change;
    }
    
    public static int getMinNumberOfCoinsToMakeChange(int [] denoms, int amount, int index) {
        if (index == denoms.length - 1 && amount % denoms[index] == 0 ) {
            return amount / denoms[index];
        } else if (index == denoms.length - 1) {
            return 0;
        }
        
        int coins = 0;
        int denom = denoms[index];
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i * denom  <= amount; i++) {
            int remainingAmount = amount - (i * denom);
            if (remainingAmount == 0) {
                // That means we found a way so we need to increase the count
                coins = i;
            } else {
                int numOfCoins = getMinNumberOfCoinsToMakeChange(denoms, remainingAmount, index + 1);
                if (numOfCoins != 0) {
                    coins = numOfCoins + i;
                }
            }
            
            if (coins != 0) {
                minCoins = Math.min(coins, minCoins);
            }
        }
        
        return minCoins;
    }
    
}
