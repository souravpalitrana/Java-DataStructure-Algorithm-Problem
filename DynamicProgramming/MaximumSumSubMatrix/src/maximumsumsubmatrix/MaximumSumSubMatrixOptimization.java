/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumsumsubmatrix;

/**
 * Time Complexity O(w * h) Space Complexity O(w * h)
 * @author souravpalit
 */
public class MaximumSumSubMatrixOptimization {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*int[][] matrix = new int[][] {
            {5, 3, -1, 5}, 
            {-7, 3, 7, 4}, 
            {12, 8, 0, 0}, 
            {1, -8, -8, 2}
        };
        int size = 2;*/
        
        
        int[][] matrix = new int[][] {
            {2, 4},
            {5, 6},
            {-3, 2}
        };
        int size = 2;
        
        
        /*int[][] matrix = new int[][] {
            {3, -4, 6, -5, 1},
            {1, -2, 8, -4, -2},
            {3, -8, 9, 3, 1},
            {-7, 3, 4, 2, 7},
            {-3, 7, -5, 7, -6}
        };
        
        int size = 3;*/
        System.out.println(maximumSumSubMatrix(matrix, size));
    }
    
    public static int maximumSumSubMatrix(int [][] matrix, int size) {
        int [][] sumMatrix = createSumMatrix(matrix, size);
        int maxSum = Integer.MIN_VALUE;
        for (int i = size - 1; i < matrix.length; i++) {
            for (int j = size - 1; j < matrix[0].length; j++) {
                int total = sumMatrix[i][j];
                
                boolean touchesTopBorder = i - size < 0;
                if (!touchesTopBorder) {
                    total -= sumMatrix[i - size][j];
                }
                
                boolean touchesLeftBorder = j - size < 0;
                if (!touchesLeftBorder) {
                    total -= sumMatrix[i][j - size];
                }
                
                
                if (!touchesTopBorder && !touchesLeftBorder) {
                    total += sumMatrix[i - size][j - size];
                }
                
                maxSum = Math.max(total, maxSum);
            }
        }
        
        return maxSum;
    }
    
    public static int [][] createSumMatrix(int [][] matrix, int size) {
        int [][] sumMatrix = new int [matrix.length][matrix[0].length];
        
        sumMatrix[0][0] = matrix[0][0];
        
        for (int i = 1; i < matrix[0].length; i++) {
            sumMatrix[0][i] = sumMatrix[0][i - 1] + matrix[0][i]; 
        }
        
        for (int i = 1; i < matrix.length; i++) {
            sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0]; 
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                sumMatrix[i][j] = 
                        sumMatrix[i - 1][j] + sumMatrix[i][j - 1] 
                        - sumMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }
        
        return sumMatrix;
    }
}
