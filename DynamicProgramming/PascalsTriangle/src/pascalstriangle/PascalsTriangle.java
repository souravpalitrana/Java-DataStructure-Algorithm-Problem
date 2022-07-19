/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascalstriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode: 118. Pascal's Triangle
 * Problem Link: https://leetcode.com/problems/pascals-triangle/
 * @author souravpalit
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        
        result.add(Arrays.asList(1));
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }
            result.add(currentRow);
        }
        
        return result;
    }
    
}
