/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggleboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * We are using trie here. So for trie construction it will take ns time and ns
 * space. Again for visited marking we are using nm space where nm is matrix size
 * so total space complexity is O(ns + nm)
 * Now for searching we are traversing the whole board which is nm and for each
 * position we are checking 8 neighbors which will we repeat s time where s is
 * the highest length of a word so total Time complexity is O (nm8^s + ns) here ns
 * is for finding n word in trie
 * @author souravpalit
 */
public class BoggleBoard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String boggleBoard [][] = {
            {"t", "h", "i", "s", "i", "s", "a"},
            {"s", "i", "m", "p", "l", "e", "x"},
            {"b", "x", "x", "x", "x", "e", "b"},
            {"x", "o", "g", "g", "l", "x", "o"},
            {"x", "x", "x", "D", "T", "r", "a"},
            {"R", "E", "P", "E", "A", "d", "X"},
            {"x", "x", "x", "x", "x", "x", "x"},
            {"N", "O", "T", "R", "E", "-", "P"},
            {"x", "x", "D", "E", "T", "A", "E"}
        
        };
        
        String words [] = {"this", "is", "not", "a", "simple", "boggle", "board",
        "test", "REPEATED", "NOTRE-PEATED"};
        
        List<String> result = findWordsInBoggleBoard(boggleBoard, words);
        
        for (String word : result) {
            System.out.println(word);
        }
    }
    
    public static List<String> findWordsInBoggleBoard(String [][] boggleBoard, 
            String [] words) {
        Set<String> result = new HashSet<String>();
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.add(word);
        }
        
        boolean visited [][] = new boolean[boggleBoard.length][boggleBoard[0].length];
        
        for (int i = 0; i < boggleBoard.length; i++) {
            for (int j = 0; j < boggleBoard[0].length; j++) {
                explore(i, j, boggleBoard, trie.root, visited, result);
            }
        }
        
        List<String> finalResult = new ArrayList<String>();
        finalResult.addAll(result);
        return finalResult;
    }
    
    public static void explore(int i, int j, String [][] boggleBoard, 
            TrieNode node, boolean [][] visited, Set<String> result) {
       if (visited[i][j]) {
           return;
       }
     
       char letter = boggleBoard[i][j].charAt(0);
       if (!node.children.containsKey(letter)) {
           return;
       }
       
       visited[i][j] = true;
       node = node.children.get(letter);
      
       if (node.children.containsKey('*')) {
           result.add(node.children.get('*').word);
       }
       
       List<Integer[]> adjacents = getAdjacents(i, j, boggleBoard);
       
       for (Integer [] adjacent : adjacents) {
           explore(adjacent[0], adjacent[1], boggleBoard, node, visited, result);
       }
       
       visited[i][j] = false;
       
    }
    
    public static List<Integer[]> getAdjacents(int i, int j, String [][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
      
        List<Integer[]> adjacents = new ArrayList<Integer[]>();
        
        // Top
        if (i > 0) {
            adjacents.add(new Integer [] {i - 1, j});
        }
        
        // Top Right
        if (i > 0 && j < colSize -1) {
            adjacents.add(new Integer [] {i -1, j + 1});
        }
        
        // Right
        if (j < colSize - 1) {
            adjacents.add(new Integer [] {i, j + 1});
        }
        
        // Bottom Right
        if (i < rowSize - 1 && j < colSize -1) {
            adjacents.add(new Integer [] {i + 1, j + 1});
        }
        
        // Bottom
        if (i < rowSize - 1) {
            adjacents.add(new Integer [] {i + 1, j});
        }
        
        // Bottom Left
        if (i < rowSize - 1 && j > 0) {
            adjacents.add(new Integer [] {i + 1, j - 1});
        }
        
        // Left
        if (j > 0) {
            adjacents.add(new Integer [] {i, j - 1});
        }
        
        // Top Left
        if (i > 0 && j > 0) {
            adjacents.add(new Integer [] {i - 1, j - 1});
        }
        
        return adjacents;
    }
    
}
