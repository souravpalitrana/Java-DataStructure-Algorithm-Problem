/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayzigzagtraverse;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity O(m*n) and space complexity O(n)
 * @author souravpalit
 */
public class ArrayZigzagTraverse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] array = {
            {1,   2,  3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10,  9,  8, 7}
        };
        
        List<Integer> zigZagged = applyZigZagTraverse(array);
        
        for (Integer value : zigZagged) {
            System.out.print(value + " ");
        }
    }
    
    public static List<Integer> applyZigZagTraverse(int [][] array) {
        List<Integer> result = new ArrayList<Integer>();
        int height = array.length - 1;
        int width = array[0].length - 1;
        int row = 0;
        int col = 0;
        boolean isGoingDown = true;
        
        while (!isOutOfBounds(row, col, height, width)) {
            result.add(array[row][col]);
            
            if (isGoingDown) {
                // now check it is first col or last row
                if (col == 0 || row == height) {
                    isGoingDown = false;
                    
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    col--;
                    row++;
                }
            } else {
                if (row == 0 || col == width) {
                    isGoingDown = true;
                    
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }
        
        return result;
    }
    
    public static boolean isOutOfBounds(int row, int col, int height, int width) {
        return (row < 0 || row > height || col < 0 || col > width);
    }
    
}
