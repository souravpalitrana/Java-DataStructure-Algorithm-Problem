/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levenshteindistance;

/**
 * Time Complexity: O(n*m) and Space Complexity: O(n*m) where n and m 
 * are the length of string 1 and 2 respectively
 * @author souravpalit
 */
public class LevenshteinDistance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";
        
        System.out.println("Levenshtein Distance : " + calculateLevenshteinDistance(str1, str2));
    }
    
    public static int calculateLevenshteinDistance(String str1, String str2) {
        int [][] edits = new int [str1.length() + 1][str2.length() + 1];
        for (int col = 0; col < edits[0].length; col++) {
            edits[0][col] = col;
        }
        
        for (int row = 0; row < edits.length; row++) {
            edits[row][0] = row;
        }
        
        for (int row = 1; row < edits.length; row++) {
            for (int col = 1; col < edits[row].length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    edits[row][col] = edits[row - 1][col - 1];
                } else {
                    edits[row][col] = 1 + 
                            Math.min(edits[row - 1][col - 1], Math.min(edits[row - 1][col], edits[row][col - 1]));
                }
            }
        }
        
        return edits[str1.length()][str2.length()];
    }
    
}
