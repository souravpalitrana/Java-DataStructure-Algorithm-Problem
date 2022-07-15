/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxareaofisland;

/**
 * Leetcode: 695. Max Area of Island
 * Problem Link: https://leetcode.com/problems/max-area-of-island/
 * @author souravpalit
 */
public class MaxAreaOfIsland {

    // TC: O(R*C) SC: O(R*C)
    int area = 0;
    int [] directions = {-1, 0, 1, 0, -1}; // Top // Right // bottom // Left
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = 1;
                    calculateArea(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    
    void calculateArea(int [][] grid, int row, int col) {
        if (grid[row][col] != 1) {
            return;
        }
        
        grid[row][col] = 0;
        
        for (int i = 0; i < directions.length - 1; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];
            
            if (newRow < 0 || newRow >= grid.length || 
                newCol < 0 || newCol >= grid[0].length || grid[newRow][newCol] == 0) {
                continue;
            }
            area++;
            calculateArea(grid, newRow, newCol);
        }
    }
    
}
