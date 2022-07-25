/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch;

/**
 * Leetcode: 79. Word Search
 * Problem Link: https://leetcode.com/problems/word-search/
 * @author souravpalit
 */
public class WordSearch {

    int [] directions = {-1, 0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isPresent(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean isPresent(
        char[][] board, 
        String word,
        int row,
        int col,
        int currentCharIdx) {
        
        if (board[row][col] == word.charAt(currentCharIdx) && currentCharIdx == word.length() - 1) {
            return true;
        } else if (board[row][col] != word.charAt(currentCharIdx)) {
            return false;
        }
        
        char ch = board[row][col];
        board[row][col] = '*';
        char nextChar = word.charAt(currentCharIdx + 1);
        
        for (int i = 0; i < directions.length - 1; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];
            
            if (newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length &&
               board[newRow][newCol] == nextChar) {
                if (isPresent(board, word, newRow, newCol, currentCharIdx + 1)) {
                    return true;
                }
            }
        }
        
        board[row][col] = ch;
        
        return false;
    }
    
}
