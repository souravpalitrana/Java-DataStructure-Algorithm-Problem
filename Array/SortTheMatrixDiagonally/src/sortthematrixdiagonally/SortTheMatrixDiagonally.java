/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortthematrixdiagonally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode: 1329. Sort the Matrix Diagonally
 * Problem Link: https://leetcode.com/problems/sort-the-matrix-diagonally/
 * @author souravpalit
 */
public class SortTheMatrixDiagonally {

    // TC: O(mnlog(min(n,m)))
    // SC: O(min(n,m))
    public int[][] diagonalSort(int[][] mat) {
        for (int row = 0; row < mat.length ; row++) {
            replaceValues(mat, addValues(mat, row, 0), row, 0);
        }
        
        for (int col = 1; col < mat[0].length; col++) {
            replaceValues(mat, addValues(mat, 0, col), 0, col);
        }
        
        return mat;
    }
    
    private List<Integer> addValues(int [][] mat, int row, int col) {
        List<Integer> values = new ArrayList<>();
        while (row < mat.length && col < mat[0].length) {
            values.add(mat[row][col]);
            row++;
            col++;
        }
        if (values.size() > 1) {
            Collections.sort(values);
        }
        return values;
    }
    
    private void replaceValues(int [][] mat, List<Integer> values, int row , int col) {
        int idx = 0;
        while (row < mat.length && col < mat[0].length) {
            mat[row][col] = values.get(idx);
            idx++;
            row++;
            col++;
        }
    } 
}
