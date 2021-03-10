/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiraltraverse;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n) and Space O(n) where n is the number of element in 
 * the matrix
 * @author souravpalit
 */
public class SpiralTraverse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*int [][] array = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        };*/
        
        /*int [][] array = {
            { 1,  2,  3, 4},
            {10, 11, 12, 5},
            { 9,  8,  7, 6}
        };*/
        
        int [][] array = {
            {1, 2, 3},
            {12, 13, 4},
            {11, 14, 5},
            {10, 15, 6},
            {9, 8, 7}
        };
        
        /*int [][] array = {
            {4,   2,  3,  6,  7,  8,  1,  9,  5, 10},
            {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}
        };*/
        
        List<Integer> spiralArray = getSpiralArray(array);
        
        for (int i = 0; i < spiralArray.size(); i++) {
            System.out.print(spiralArray.get(i) + " ");
        }
    }
    
    public static List<Integer> getSpiralArray(int [][] array) {
        List<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) {
            return result;
        }
        
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;
        
        while (startRow <= endRow && startCol <= endCol) {
            
            // top
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }
            
            // Right
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }
            
            // Bottom
            for (int col = endCol - 1; col >= startCol; col--) {
                // Handling the edge case when there is a single row
		// in the middle of the matrix. In this case, we don't
		// want to double-count the values in this row, which
                // we have already counted in the first for loop abobe
                if (startRow == endRow) break;
                result.add(array[endRow][col]);
            }
            
            // left
            for (int row = endRow - 1; row > startRow; row--) {                
                // Handling the edge case when there is a single row
		// in the middle of the matrix. In this case, we don't
		// want to double-count the values in this row, which
                // we have already counted in the second for loop abobe
                if (startCol == endCol) break;
                result.add(array[row][startCol]);
            }
            
            startRow += 1;
            startCol += 1;
            endRow -= 1;
            endCol -= 1;
        }
        
        return result;
    }
   
}
