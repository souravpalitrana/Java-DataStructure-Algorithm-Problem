/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxprofitwithktransactions;

import java.util.Arrays;

/**
 * Space complexity optimized from O(nk) to O(n) 
 * Time Complexity: O(nk) Space Complexity: O(n)
 * @author souravpalit
 */
public class MaxProfitWithKTransactionsTFinalOptimization {

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
        
        int [] oddProfit = new int [prices.length];
        int [] evenProfit = new int [prices.length];
        
        // by default Array value is zero so no need to initialize first row
        int [] currentProfit;
        int [] previousProfit;
        for (int t = 1; t <= k; t++) {
            int profitTillNow = Integer.MIN_VALUE;
            if (t % 2 == 0) {
                currentProfit = evenProfit;
                previousProfit = oddProfit;
            } else {
                currentProfit = oddProfit;
                previousProfit = evenProfit;
            }
            for (int d = 1; d < prices.length; d++) {
                
                profitTillNow = Math.max(profitTillNow, previousProfit[d - 1] - prices[d - 1]);
                currentProfit[d] = Math.max(currentProfit[d - 1], prices[d] + profitTillNow);
            }
        }
        
        return (k % 2 == 0) ? evenProfit[prices.length - 1] : oddProfit[prices.length - 1];
    }
    
}
