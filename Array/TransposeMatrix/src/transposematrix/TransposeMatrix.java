/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transposematrix;

/**
 *
 * @author souravpalit
 */
public class TransposeMatrix {

    // Time Complexity: O(mn)
    // Space Complexity: O(mn) where m is the row size and n is the col size
    public int[][] transpose(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int [][] transposeMatrix = new int [colSize][rowSize];
        
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                transposeMatrix[col][row] = matrix[row][col];
            }
        }
        
        return transposeMatrix;
    }

}
