/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquepathsii;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author souravpalit
 */
public class UniquePathIISolution {

    // Time Complexity: O(m*n) Space Complexity: O(m*n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       Map<Pair, Integer> cache = new HashMap<>();
       return numberOfWays(obstacleGrid, 0, 0, cache);
    }
    
    
    public int numberOfWays(
            int[][] obstacleGrid, 
            int row, 
            int col,
            Map<Pair, Integer> cache) {
        int rowSize = obstacleGrid.length;
        int colSize = obstacleGrid[0].length;
        
        if (row >= rowSize || col >= colSize || obstacleGrid[row][col] == 1) {
            return 0;
        } else if (row == rowSize - 1 && col == colSize - 1) {
            return 1;
        } 
        
        Pair pair = new Pair(row, col);
        
        if (cache.containsKey(pair)) {
            return cache.get(pair);
        }
        
        int ways = numberOfWays(obstacleGrid, row + 1, col, cache) 
                + numberOfWays(obstacleGrid, row, col + 1, cache);
        
        cache.put(pair, ways);
        return ways;
    }
    
}
