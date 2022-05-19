/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestincreasingpathinamatrix;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class Solution {
    
    private int [][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    // DFS with memorization
    public int longestIncreasingPath(int[][] matrix) {
        int [][] memo = new int [matrix.length][matrix[0].length];
        int ans = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
               ans = Math.max(ans, explore(matrix, row, col, memo));
            }
        }
        
        return ans;
    }
    
    public int explore(int [][] matrix, int row, int col, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int rowSize = memo.length;
        int colSize = memo[0].length;
        
        for (int i = 0; i < directions.length; i++) {
            int nextRow = row + directions[i][0];
            int nextCol = col + directions[i][1];
            
            if (nextRow < rowSize && nextRow >= 0 && 
                    nextCol >= 0 && nextCol < colSize && 
                    matrix[nextRow][nextCol] > matrix[row][col]) {
                memo[row][col] = Math.max(memo[row][col], explore(matrix, nextRow, nextCol, memo));
            }
        }
        memo[row][col] += 1;
        return memo[row][col];
    }
     
}
