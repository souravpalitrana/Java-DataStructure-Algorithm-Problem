/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removeislands;

/**
 *
 * @author souravpalit
 */
public class RemoveIslands {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] input = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}
        };
        
        System.out.println("Before removing islands");
        printImage(input);
        
        removeIslands(input);
        
        System.out.println("After removing islands");
        printImage(input);
    }
    
    public static void removeIslands(int [][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        boolean [][] visited = new boolean [matrix.length][matrix[0].length];
        
        // first row
        for (int col = 0; col < colSize; col++) {
            floodFill(matrix, 0, col, visited);
        }
        
        // first col
        for (int row = 0; row < colSize; row++) {
            floodFill(matrix, row, 0, visited);
        }
        
        // last row
        for (int col = 0; col < colSize; col++) {
            floodFill(matrix, rowSize - 1, col, visited);
        }
        
        // first col
        for (int row = 0; row < colSize; row++) {
            floodFill(matrix, row, colSize - 1, visited);
        }
        
        for (int row = 1; row < rowSize -1; row++) {
            for (int col = 1; col < colSize - 1; col++) {
                if (!visited[row][col] && matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
    
    public static void floodFill(int [][] matrix, int row, int col, boolean [][] visited) {
        if ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length)) {
            
            if (matrix[row][col] == 1 && !visited[row][col]) {
                visited[row][col] = true;
                floodFill(matrix, row - 1, col, visited);
                floodFill(matrix, row + 1, col, visited);
                floodFill(matrix, row, col + 1, visited);
                floodFill(matrix, row, col - 1, visited);
            }
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
