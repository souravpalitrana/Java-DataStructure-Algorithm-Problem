/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;

/**
 * As the board is 9 always so it is constant time and constant space
 * @author souravpalit
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int[][] inputValues =
        new int[][] {
          {7, 8, 0, 4, 0, 0, 1, 2, 0},
          {6, 0, 0, 0, 7, 5, 0, 0, 9},
          {0, 0, 0, 6, 0, 1, 0, 7, 8},
          {0, 0, 7, 0, 4, 0, 2, 6, 0},
          {0, 0, 1, 0, 5, 0, 9, 3, 0},
          {9, 0, 4, 0, 6, 0, 0, 0, 5},
          {0, 7, 0, 3, 0, 0, 0, 1, 2},
          {1, 2, 0, 0, 0, 7, 4, 0, 0},
          {0, 4, 9, 2, 0, 6, 0, 0, 7}
        };*/
                
          /*      new int[][] {
          {7, 8, 0, 4, 3, 9, 1, 2, 6},
          {6, 0, 0, 8, 7, 5, 3, 4, 9},
          {4, 0, 0, 6, 2, 1, 5, 7, 8},
          {8, 0, 7, 9, 4, 3, 2, 6, 1},
          {2, 0, 1, 0, 5, 8, 9, 3, 4},
          {9, 0, 4, 0, 6, 2, 0, 8, 5},
          {5, 7, 0, 3, 4, 9, 0, 1, 2},
          {1, 2, 0, 0, 8, 7, 4, 0, 3},
          {3, 4, 9, 2, 1, 6, 8, 0, 7}
        };*/
          
          /*int[][] inputValues =
        new int[][]  {
            {7, 8, 0, 4, 0, 0, 1, 2, 0},
            {6, 0, 0, 0, 7, 5, 0, 0, 9},
            {0, 0, 0, 6, 0, 1, 0, 7, 8},
            {0, 0, 7, 0, 4, 0, 2, 6, 0},
            {0, 0, 1, 0, 5, 0, 9, 3, 0},
            {9, 0, 4, 0, 6, 0, 0, 0, 5},
            {0, 7, 0, 3, 0, 0, 0, 1, 2},
            {1, 2, 0, 0, 0, 7, 4, 0, 0},
            {0, 4, 9, 2, 0, 6, 0, 0, 7}
        };*/
          
          /*int[][] inputValues =
        new int[][]  {
            {0, 0, 0, 0, 3, 0, 0, 0, 9},
            {0, 4, 0, 5, 0, 0, 0, 7, 8},
            {2, 9, 0, 0, 0, 1, 0, 5, 0},
            {0, 7, 8, 0, 0, 3, 0, 0, 6},
            {0, 3, 0, 0, 6, 0, 0, 8, 0},
            {6, 0, 0, 8, 0, 0, 9, 3, 0},
            {0, 6, 0, 9, 0, 0, 0, 2, 7},
            {7, 2, 0, 0, 0, 5, 0, 6, 0},
            {8, 0, 0, 0, 7, 0, 0, 0, 0}
        };*/
          
          int[][] inputValues =
        new int[][]  {
            {0, 0, 0, 0, 3, 0, 0, 0, 9},
            {0, 4, 0, 5, 0, 0, 0, 7, 8},
            {2, 9, 0, 0, 0, 1, 0, 5, 0},
            {0, 7, 8, 0, 0, 3, 0, 0, 6},
            {0, 3, 0, 0, 6, 0, 0, 8, 0},
            {6, 0, 0, 8, 0, 0, 9, 3, 0},
            {0, 6, 0, 9, 0, 0, 0, 2, 7},
            {7, 2, 0, 0, 0, 5, 0, 6, 0},
            {8, 0, 0, 0, 7, 0, 0, 0, 0}
        };
          
          
          
        
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < inputValues.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < inputValues[i].length; j++) {
                row.add(inputValues[i][j]);
            }
            input.add(row);
        }
        
        ArrayList<ArrayList<Integer>> output = solveSudoku(input);
        
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + " ");
            }
            
            System.out.println();
        }
    }
    
    public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        boolean status = canSolve(board, 0, 0);
        return board;
    }
    
    public static boolean canSolve(ArrayList<ArrayList<Integer>> board, int row, int col) {
        if (row > board.size() || col > board.size()) {
            return true;
        }
        
        for (int i = row; i < board.size(); i++) {
            for (int j = col; j < board.size(); j++) {
                if (board.get(i).get(j) != 0) {
                    continue;
                }
                
                boolean isPlaced = false;
                for (int k = 1; k < 10; k++) {
                    if (canPlace(board, i, j, k)) {
                        isPlaced = true;
                        board.get(i).set(j, k);
                        int newRow  = 0, newCol = 0;
                        if (j == board.get(0).size() - 1) {
                            newRow = i + 1;
                            newCol = 0;
                        } else {
                            newCol = j + 1;
                            newRow = i;
                        } 
                        if (canSolve(board, newRow, newCol)) {
                            return true;
                        } else {
                           isPlaced = false;
                           board.get(i).set(j, 0); 
                        }
                    }
                }
                
                if (!isPlaced) {
                    return false;
                }
            }
            if (col != 0) {
                col = 0;
            }
        }
        
       return true;
    }
    
    public static boolean canPlace(ArrayList<ArrayList<Integer>> board, int row, int col, int value) {
        if (board.get(row).contains(value)) {
            return false;
        }
        
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(col) == value) {
                return false;
            }
        }

        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3; 

        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int rowToCheck = startingRow + rowIdx;
                int colToCheck = startingCol + colIdx;
                int existingValue = board.get(rowToCheck).get(colToCheck);
                if (existingValue == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
