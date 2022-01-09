/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumsumsubmatrix;

/**
 * Time Complexity O(w * h * n) Space Complexity O(1)
 * @author souravpalit
 */
public class MaximumSumSubMatrix {

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
        int initialSum = initialSum(matrix, size);
        int firstCol = nextColSum(matrix, size, 0, 0);
        int firstRow = nextRowSum(matrix, size, 0, 0);
        int maxSum = initialSum;
        int firstMatrixSum = initialSum;
        
        for (int i = 0; i <= matrix.length - size; i++) {
            if (i != 0) {
                int nextRowSum = nextRowSum(matrix, size, size - 1 + i, 0);
                initialSum = firstMatrixSum + nextRowSum - firstRow;
                firstMatrixSum = initialSum;
                firstRow =   nextRowSum(matrix, size, i, 0);
                firstCol = nextColSum(matrix, size, i, 0);
            }
            
            for (int j = size; j < matrix[0].length; j++) {
                int nextColSum =  nextColSum(matrix, size, i, j);
                int currentSum = initialSum + nextColSum - firstCol;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                
                initialSum = currentSum;
                firstCol = nextColSum(matrix, size, i, j + 1 - size);
            }
        }
        
        if (initialSum > maxSum) {
             maxSum = initialSum;
        }
        
        return maxSum;
    }
    
    public static int initialSum(int [][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += matrix[i][j];
            }
        }
        
        return sum;
    }
    
    public static int nextRowSum(int [][] matrix, int size, int row, int col) {
        int sum = 0;
        for (int j = col; j < col + size; j++) {
            sum += matrix[row][j];
        }
        
        return sum;
    }
    
    public static int nextColSum(int [][] matrix, int size, int row, int col) {
        int sum = 0;
        for (int i = row; i < row + size; i++) {
            sum += matrix[i][col];
        }
        
        return sum;
    }
}
