/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueen;

/**
 * Write an algorithm to print all ways of arranging n queens on on n*n chess board
 * so that none of them share the same row, column or diagonal.
 * @author souravpalit
 */
public class NQueen {
    
    public static final int N = 4;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        solveNQueenProblem();
    }
    
    public static void solveNQueenProblem() {
        
        int board [][] = new int [N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
        
        if (solveNQueen(board, 0)) {
            printSolution(board);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
    
    public static boolean solveNQueen(int board[][], int col) {
        
        if (col >= N) {
            return true;
        }
        
        for (int i = 0; i < N; i++) {
            
            if (canPlaceQueen(board, i, col)) {
                board[i][col] = 1;
                
                if (solveNQueen(board, col + 1)) {
                    return true;
                } else {
                    board[i][col] = 0;
                }
            }
        }
        
        return false;
    }
    
    
    public static boolean canPlaceQueen(int board[][], int row, int col) {
        
        // row-wise
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        
        // diagonal wise left lower diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // diagonal wise upper left diagonal
        for(int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    /* A utility function to print solution */
    public static void printSolution(int board[][]) { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
}
