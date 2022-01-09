/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxprofitwithktransactions;

import java.util.Arrays;

/**
 * Time complexity optimized from O(n^2*k) to O(nk) 
 * Time Complexity: O(nk) Space Complexity: O(nk)
 * @author souravpalit
 */
public class MaxProfitWithKTransactionsTFirstOptimization {

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
            int profitTillNow = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                
                profitTillNow = Math.max(profitTillNow, profit[t - 1][d - 1] - prices[d - 1]);
                profit[t][d] = Math.max(profit[t][d - 1], prices[d] + profitTillNow);
            }
        }
        
        return profit[k][prices.length - 1];
    }
    
}
