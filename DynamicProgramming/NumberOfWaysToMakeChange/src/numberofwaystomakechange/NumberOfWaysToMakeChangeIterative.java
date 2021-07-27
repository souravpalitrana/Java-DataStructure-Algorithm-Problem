/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofwaystomakechange;

/**
 * Time Complexity: O(n*m) where n is the coin length and m is the amount
 * Space Complexity:O(m) because of call stack
 * @author souravpalit
 */
public class NumberOfWaysToMakeChangeIterative {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] denoms = {1, 5};
        int amount = 6;
        
        System.out.println("Number of ways to make change : " + getNumberOfWaysToMakeChange(denoms, amount));
    }
    
    public static int getNumberOfWaysToMakeChange(int [] denoms, int amount) {
        int [] ways = new int [amount + 1];
        ways[0] = 1;
        
        for (int i = 0; i < denoms.length; i++) {
            for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
                if (denoms[i] <= currentAmount) {
                    ways[currentAmount] = ways[currentAmount] + ways[currentAmount - denoms[i]];
                }
            }
        }
        
        return ways[amount];
    }
}
