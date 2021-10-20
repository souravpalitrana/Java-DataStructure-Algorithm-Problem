/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxprofitwithktransactions;

import java.util.Arrays;

/**
 * Time Complexity: O(n^2*k) Space Complexity: O(nk)
 * @author souravpalit
 */
public class MaxProfitWithKTransactions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] prices = {5, 11, 3, 50, 60, 90};
        int k = 2;
        System.out.println(maxProfitWithKTransactions(prices, k));
    }
    
    public static int maxProfitWithKTransactions(int prices[], int k) {
        if (prices.length < 2) { return 0; }
        
        int [][] profit = new int [k + 1][prices.length];
        
        // by default Array value is zero so no need to initialize first row
        
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < prices.length; d++) {
                int profitTillNow = Integer.MIN_VALUE;
                
                for (int x = 0; x < d; x++) {
                    profitTillNow = Math.max(profitTillNow, profit[t - 1][x] - prices[x]);
                }
                
                profit[t][d] = Math.max(profit[t][d - 1], prices[d] + profitTillNow);
            }
        }
        
        return profit[k][prices.length - 1];
    }
    
}
