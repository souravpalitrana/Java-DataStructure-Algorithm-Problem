/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumpassesofmatrix;

import java.util.ArrayList;

/**
 * Time Complexity O(w*h)^2 
 * Space Complexity O(w * h)
 * @author souravpalit
 */
public class MinimumPassesOfMatrix {

    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matrix = new int[][]{
            {0, -1, -3, 2, 0},
            {1, -2, -5, -1, -3},
            {3, 0, 0, -4, -1}
        };
        int expected = 3;
        int actual = minimumPassesOfMatrix(matrix);
        
        System.out.println("Expected = " + expected + "  Actual =" + actual);
    }
    
    public static int minimumPassesOfMatrix(int[][] matrix) {

        int passCount = 0;
        while (true) {
            Result result = change(matrix);
            if (result.isChanged) {
                passCount++;
            }

            if (!result.isChanged && result.hasAtLeastOneNegativeValue) {
                // This means no changes done but still negative value
                // that means could not convert to negative
                passCount = -1;
                break;
            } else if (result.isChanged && !result.hasAtLeastOneNegativeValue) {
                // no negative value. all converted
                break;
            } else if (!result.isChanged && !result.hasAtLeastOneNegativeValue) {
                break;
            }
        }

        return passCount;
    }
    
    public static Result change(int[][] matrix) {
        Result result = new Result();
        ArrayList<String> ignoreList = new ArrayList<String>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0 && hasPositiveAdjacent(matrix, i, j, ignoreList)) {
                    ignoreList.add(getKey(i, j));
                    result.isChanged = true;
                    matrix[i][j] = -matrix[i][j];
                } else if (matrix[i][j] < 0) {
                    result.hasAtLeastOneNegativeValue = true;
                }
            }
        }

        return result;
    }
    
    public static boolean hasPositiveAdjacent(int[][] matrix, int i, int j, ArrayList<String> ignoreList) {
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > 0 && !ignoreList.contains(getKey(i, j + 1))) {
            return true;
        } else if (j - 1 >= 0 && matrix[i][j - 1] > 0 && !ignoreList.contains(getKey(i, j - 1))) {
            return true;
        } else if (i + 1 < matrix.length && matrix[i + 1][j] > 0 && !ignoreList.contains(getKey(i + 1, j))) {
            return true;
        } else if (i - 1 >= 0 && matrix[i - 1][j] > 0 && !ignoreList.contains(getKey(i - 1, j))) {
            return true;
        } else {
            return false;
        }
    }

    public static String getKey(int i, int j) {
        return i + "," + j;
    }

    static class Result {

        boolean isChanged;
        boolean hasAtLeastOneNegativeValue;
    }

}
