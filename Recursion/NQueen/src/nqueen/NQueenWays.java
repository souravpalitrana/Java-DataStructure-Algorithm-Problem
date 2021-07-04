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
public class NQueenWays {
    
    public static void main(String[] args) {
        findNumberOfWaysToSolve(8);
    }
    
    public static void findNumberOfWaysToSolve(int n) {
        int [][] board = new int [n][n];
        
        System.out.println("Number of way to solve : " + findNumberOfWaysToSolve(board, 0));
    }
    
    
    public static int findNumberOfWaysToSolve(int [][] board, int col) {
        if (col >= board.length) {
            return 1;
        }
        // Moving through column by changing row
        int solutions = 0;
        for (int i = 0; i < board.length; i++) {
            if (canPlaceQueen(board, i, col)) {
                board[i][col] = 1;
                solutions += findNumberOfWaysToSolve(board, col + 1);
                board[i][col] = 0;
            }
        }
        
        return solutions;
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
        for(int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
}
