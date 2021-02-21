/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riversizes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class RiverSizes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] input = {
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0}
        };
        
        List<Integer> riverSizes = findRiverSizes(input);
        
        for (Integer value : riverSizes) {
            System.out.print(value + "  ");
        }
    } 

    public static List<Integer> findRiverSizes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> riverSizes = new ArrayList<Integer>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    int size = floodFill(matrix, i, j, 1, 2 );
                    if (size != 0) {
                        riverSizes.add(size);
                        printImage(matrix);
                        System.out.println("-------------------");
                    }
                }
            }
        }

        return riverSizes;
    }
    
    public static int floodFill(int [][] image, int row, 
            int col, int oldColor, int newColor) {
        int count = 0;
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return 0;
        } else {
            if (image[row][col] == oldColor) { 
                image[row][col] = newColor;
                count++;
                
                count += floodFill(image, row - 1, col, oldColor, newColor); // Top
                count += floodFill(image, row + 1, col, oldColor, newColor); // Bottom
                count += floodFill(image, row, col - 1, oldColor, newColor); // Left
                count += floodFill(image, row, col + 1, oldColor, newColor); // Right
            }
            
            return count;
        }
    }
    
    public static void printImage(int [][] image) {
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[row].length; col++) {
                System.out.print(image[row][col] + " ");
            }
            System.out.println();
        }
    }
}
