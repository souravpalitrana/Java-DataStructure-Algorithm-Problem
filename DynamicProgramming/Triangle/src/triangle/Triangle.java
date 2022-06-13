/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode: 120. Triangle
 * Problem Link: https://leetcode.com/problems/triangle/
 * @author souravpalit
 */
public class Triangle {

    int minPathSum;
    Map<String, Integer> cache; 
    
    // TC: O(n^2) where n^2 is the number of cell
    // SC: O(n^2) 
    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new HashMap<>();
        return calculatePathSum(triangle, 0, 0);
    }
    
    public int calculatePathSum(
        List<List<Integer>> triangle, 
        int rowIdx, 
        int colIdx
    ) {
        
        String key = rowIdx + ":" + colIdx;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int pathSum = triangle.get(rowIdx).get(colIdx);

        if (rowIdx < triangle.size() - 1) {
            pathSum += Math.min(calculatePathSum(triangle, rowIdx + 1,colIdx),calculatePathSum(triangle, rowIdx + 1, colIdx + 1));
        }
        
        cache.put(key, pathSum);
        return pathSum;
    }
    
}
