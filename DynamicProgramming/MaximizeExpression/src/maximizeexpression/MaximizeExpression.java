/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximizeexpression;

/**
 * Time Complexity: O(n^4) Space Complexity: O(1)
 * @author souravpalit
 */
public class MaximizeExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = new int[] {3, 6, 1, -3, 2, 7};
        
        System.out.println(maximizeExpression(array));
    }
    
    public static int maximizeExpression(int [] array) {
        if (array.length < 4) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    for (int l = k + 1; l < array.length; l++) {
                        int currentValue = evaluateExpression(array[i], array[j], array[k], array[l]);
                        maxValue = Math.max(currentValue, maxValue);
                    }
                }
            }
        }
        
        return maxValue;
    }
    
    public static int evaluateExpression(int a, int b, int c, int d) {
        return a - b + c - d;
    }
    
}
