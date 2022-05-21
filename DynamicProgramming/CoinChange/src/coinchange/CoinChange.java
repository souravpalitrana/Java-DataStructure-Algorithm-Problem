/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

import java.util.Arrays;

/**
 *
 * @author souravpalit
 */
public class CoinChange {

    // Time Complexity: O(n*m) where n is the amount and m is the number of coins
    // Space Complexity:: O(n)
    public int coinChange(int[] coins, int amount) {
        int[] changes = new int[amount + 1];
        Arrays.fill(changes, Integer.MAX_VALUE);
        changes[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];

            for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
                if (coin <= currentAmount) {
                    int remainingAmount = currentAmount - coin;
                    if (changes[remainingAmount] != Integer.MAX_VALUE) {
                        changes[currentAmount] = Math.min(changes[currentAmount], 1 + changes[remainingAmount]);
                    }

                }
            }
        }

        return changes[amount] == Integer.MAX_VALUE ? -1 : changes[amount];
    }
}
