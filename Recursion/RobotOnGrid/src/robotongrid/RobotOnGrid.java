 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotongrid;

/**
 * Imagine a robot sitting on the left corner of grid with r rows and c columns. 
 * The robot can only move in two directions, right and down, but certain cells are 
 * "off limits" such that the robot cannot step on them. Design an algorithm to find
 * a path for the robot from the top left to the bottom right.
 * 
 * Lets consider cell value 0 means empty cell and 2 means blocked cell and 1 is 
 * valid move.
 * @author souravpalit
 */
public class RobotOnGrid {
  
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*int board [][] = {
            {0,0,0,0}, 
            {0,0,0,2}, 
            {0,2,0,2}, 
            {2,0,0,0}};*/
        
        /*int board [][] = {
            {0,0,0,0}, 
            {0,0,2,0}, 
            {2,0,0,2}, 
            {0,2,0,0}};*/
        
        int board [][] = {
            {0,0,0,2}, 
            {0,0,2,2}, 
            {2,0,0,2}, 
            {0,2,0,2}};
        
        
        /*int board [][] = {
            {0,2,0,0}, 
            {0,2,2,0}, 
            {0,0,0,2}, 
            {0,0,0,0}};*/
        
        if (hasPath(board, 0, 0)) {
            printSolution(board);
        } else {
            System.out.println("There is no way to reach the desinatioon");
        }
    }
   
    private static boolean hasPath(int board[][], int row, int col) {
        
        if (col >= board[0].length || row >= board.length || board[row][col] != 0) {
            return false;
        }
        
        for (int i = row; i < board.length; i++) {
            board[i][col] = 1;
            
            if (isAtDestination(board, i, col) || 
                    hasPath(board, i, col + 1) || 
                    hasPath(board, i+ 1, col)) {
                return true;
            } else {
                // We are setting 3 so that next time we don't need to visit or calculate for this position as
                // we already visited
                board[i][col] = 3;
                return false;
            } 
        }
        
        return false;
    }
    
    private static boolean isAtDestination(int[][] board, int row, int col) {
        return row == board.length -1 && col == board[0].length -1;
    }
    
     /* A utility function to print solution */
    private static void printSolution(int board[][]) { 
        for (int i = 0; i < board.length; i++) { 
            for (int j = 0; j < board[0].length; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
}
