/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squareofzeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n^4) Space Complexity: O(1)
 * @author souravpalit
 */
public class SquareOfZerosIteration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 1, 1, 0, 1, 0})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 0, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 1, 1, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 1, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 1, 1, 0, 1})));
        matrix.add(new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 0, 0, 0, 0, 1})));
        
        System.out.println("Is square matrix : " + squareOfZeroes(matrix));
    }
    
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        int n = matrix.size();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int squareLength = 2;
                while (squareLength <= n - col && squareLength <= n - row) {
                    if (isSquareOfZeros(matrix, row, col, squareLength)) {
                        return true;
                    }
                    squareLength++;
                }
                
            }
        }
        
        return false;
    }
    
    public static boolean isSquareOfZeros(List<List<Integer>> matrix, int rowIdx, int colIdx, int squareSize) { 
        int bottomRow = rowIdx + squareSize - 1;
        int rightCol = colIdx + squareSize - 1;
        for (int topRow = rowIdx; topRow < bottomRow + 1; topRow++) {
            if (matrix.get(topRow).get(colIdx) == 1 || matrix.get(topRow).get(rightCol) == 1) {
                return false;
            }
        }
        
        for (int leftCol = colIdx; leftCol < rightCol + 1; leftCol++) {
            if (matrix.get(rowIdx).get(leftCol) == 1 || matrix.get(bottomRow).get(leftCol) == 1) {
                return false;
            }
        }
        
        return true;
    }
    
}
