/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumpassesofmatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Time Complexity O(w * h)
 * Space Complexity O(w * h)
 * @author souravpalit
 */
public class MinimumPassesOfMatrixOptimized {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {0, -1, -3, 2, 0},
            {1, -2, -5, -1, -3},
            {3, 0, 0, -4, -1}
        };
        int expected = 3;
        int actual = minimumPassesOfMatrix(matrix);
        
        System.out.println("Expected = " + expected + "  Actual = " + actual);
    }
    
    public static int minimumPassesOfMatrix(int[][] matrix) {
        return convertNegatives(matrix);
    }
    
    // This function will convert all the negativevalue of a matrix to positive 
    // value if possible and return the number of pass required to do that.
    // If not possible to convert all negatives to positive then will return -1
    public static int convertNegatives(int [][] matrix) {
        Queue<Cell> nextQ = getAllPositiveNumbers(matrix);
        int passCount = 0;
        
        while (!nextQ.isEmpty()) {
            Queue currentQ = nextQ;
            nextQ = new LinkedList<Cell>();
            
            while (!currentQ.isEmpty()) {
                Cell cell =  (Cell) currentQ.poll();
                List<Cell> negativeNeighbors = findNegativeAdjacent(matrix, cell.row, cell.col);
                
                for (Cell negCell : negativeNeighbors) {
                    matrix[negCell.row][negCell.col] =  matrix[negCell.row][negCell.col] * -1;
                    nextQ.add(negCell);
                }
                
            }
            passCount++;
        }
        
        
        if (hasNegativeNumber(matrix)) {
            return - 1;
        }
        
        return passCount - 1;
    }
    
    public static Queue<Cell> getAllPositiveNumbers(int [][] matrix) {
        Queue<Cell> q = new LinkedList<Cell>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    q.add(new Cell(i, j));
                }
            }
        }
        
        return q;      
    }
    
    public static boolean hasNegativeNumber(int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    public static List<Cell> findNegativeAdjacent(int[][] matrix, int i, int j) {
        List<Cell> negativeNeighbors = new ArrayList<Cell>();
        
        if (j + 1 < matrix[0].length && matrix[i][j + 1] < 0) {
            negativeNeighbors.add(new Cell(i, j + 1));
        } 
        
        if (j - 1 >= 0 && matrix[i][j - 1] < 0) {
            negativeNeighbors.add(new Cell(i, j - 1));
        } 
        
        if (i + 1 < matrix.length && matrix[i + 1][j] < 0) {
            negativeNeighbors.add(new Cell(i + 1, j));
        } 
        
        if (i - 1 >= 0 && matrix[i - 1][j] < 0) {
            negativeNeighbors.add(new Cell(i - 1, j));
        } 
        
        return negativeNeighbors;
    }
    
    static class Cell {
        
        int row;
        int col;
        
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
