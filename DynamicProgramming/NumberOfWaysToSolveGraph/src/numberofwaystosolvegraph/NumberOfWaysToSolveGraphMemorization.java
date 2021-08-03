/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofwaystosolvegraph;

import java.util.HashMap;

/**
 * Time Complexity: O(n*m) Space Complexity: O(n*m)
 * @author souravpalit
 */
public class NumberOfWaysToSolveGraphMemorization {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        System.out.println(numberOfWaysToTraverseGraph(width, height));
    }
    
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        HashMap<String, Integer> cache = new HashMap<String, Integer>();
        return numberOfWaysToTraverseGraph(0, 0, height, width, cache);
    }
    
    public static int numberOfWaysToTraverseGraph(int row, int col, int actualRow, 
            int actualCol, HashMap<String, Integer> cache) {
        String key = generateKey(row, col);
        if (row == actualRow - 1 && col == actualCol - 1) {
            return 1;
        } else if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int ways = 0;
        
        if (canMoveToNext(row, col + 1, actualRow, actualCol)) {
            ways += numberOfWaysToTraverseGraph(row, col + 1, actualRow, actualCol, cache);
        }
        
        if (canMoveToNext(row + 1, col, actualRow, actualCol)) {
            ways += numberOfWaysToTraverseGraph(row + 1, col, actualRow, actualCol, cache);
        }
        
        cache.put(key, ways);
        return ways;
    }
    
    public static boolean canMoveToNext(int row, int col, int actualRow, int actualCol) {
        return row < actualRow && col < actualCol;
    }
    
    public static String generateKey(int row, int col) {
        return row + "," + col;
    }
}
