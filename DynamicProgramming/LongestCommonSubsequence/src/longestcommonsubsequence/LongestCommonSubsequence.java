/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcommonsubsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n * m * min (n,m)) Space Complexity: O(n * m * min (n,m))
 * @author souravpalit
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "zxvvyzw";
        String str2 = "xkykzpw";
        //List<Character> lcs = longestCommonSubsequence(str1, str2);
        List<Character> lcs = longestCommonSubsequenceAlternateImpl(str1, str2);
        for (char ch : lcs) {
            System.out.print(ch + "  ");
        }
        
    }
    
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // two dimention and each value will store all the character as list in
        // stead of one string
        List<List<List<Character>>> lcs = new ArrayList<List<List<Character>>>();
        
        for (int i = 0; i < str1.length() + 1; i++) {
            // Setting each row as list
            lcs.add(new ArrayList<List<Character>>());
            for (int j = 0; j < str2.length() + 1; j++) {
                // setting each cell as list to hold characters
                lcs.get(i).add(new ArrayList<Character>());
            }
        }
        
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    List<Character> chars = new ArrayList<Character>(lcs.get(i - 1).get(j - 1));
                    chars.add(str1.charAt(i - 1));
                    lcs.get(i).set(j, chars);
                } else {
                    if (lcs.get(i - 1).get(j).size() > lcs.get(i).get(j - 1).size()) {
                         lcs.get(i).set(j, lcs.get(i - 1).get(j));
                    } else {
                        lcs.get(i).set(j, lcs.get(i).get(j - 1));
                    }
                }
            }
        }
        
        return lcs.get(str1.length()).get(str2.length());
    }
    
    public static List<Character> longestCommonSubsequenceAlternateImpl(String str1, String str2) {
        Cell [][] cells = new Cell[str1.length() + 1][str2.length() + 1];
        
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                cells[row][col] = new Cell();
            }
        }
        
        for (int row = 1; row < cells.length; row++) {
            for (int col = 1; col < cells[0].length; col++) {
                Cell currentCell = cells[row][col];
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    Cell previousLcsCell = cells[row - 1][col - 1];
                    currentCell.lcsChars.addAll(previousLcsCell.lcsChars);
                    currentCell.lcsChars.add(str1.charAt(row - 1));
                } else {
                    Cell upperCell = cells[row - 1][col];
                    Cell leftCell = cells[row][col - 1];
                    
                    if (upperCell.lcsChars.size() > leftCell.lcsChars.size()) {
                        currentCell.lcsChars.addAll(upperCell.lcsChars);
                    } else {
                        currentCell.lcsChars.addAll(leftCell.lcsChars);
                    }
                }
            }
        }
        
        
        return cells[str1.length()][str2.length()].lcsChars;
    }
    
    
    static class Cell {
        List<Character> lcsChars = new ArrayList<Character>();
    }
}
