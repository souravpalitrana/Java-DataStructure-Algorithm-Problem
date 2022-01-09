/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximizeexpression;

/**
 * Time Complexity: O(n) Space Complexity: O(n)
 * @author souravpalit
 */
public class MaximizeExpressionOptimize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] array = new int[] {3, 6, 1, -3, 2, 7};
        //int [] array = new int[] {3, 9, 10, 1, 30, 40};
        
        System.out.println(maximizeExpression(array));
    }
    
    public static int maximizeExpression(int [] array) {
        if (array.length < 4) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        
        int [] maxA = new int [array.length];
        maxA[0] = array[0];
        
        int [] maxAMinusB = new int [array.length];
        initWithDefaultValue(maxAMinusB, 1);
        
        int [] maxAMinusBPlusC = new int [array.length];
        initWithDefaultValue(maxAMinusBPlusC, 2);
        
        int [] maxAMinusBPlusCMinusD = new int [array.length];
        initWithDefaultValue(maxAMinusBPlusCMinusD, 3);
        
        for (int i = 1; i < array.length; i++) {
            maxA[i] = Math.max(maxA[i - 1], array[i]);
        }
        
        for (int i = 1; i < array.length; i++) {
            int current = maxA[i - 1] - array[i];
            maxAMinusB[i] = Math.max(maxAMinusB[i - 1], current);
        }
        
        for (int i = 2; i < array.length; i++) {
            int current = maxAMinusB[i - 1] + array[i];
            maxAMinusBPlusC[i] = Math.max(maxAMinusBPlusC[i - 1], current);
        }
        
        for (int i = 3; i < array.length; i++) {
            int current = maxAMinusBPlusC[i - 1] - array[i];
            maxAMinusBPlusCMinusD[i] = Math.max(maxAMinusBPlusCMinusD[i - 1], current);
        }
        
        return maxAMinusBPlusCMinusD[array.length - 1];
    } 
    
    public static void initWithDefaultValue(int [] array, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = Integer.MIN_VALUE;
        }
    }
}
