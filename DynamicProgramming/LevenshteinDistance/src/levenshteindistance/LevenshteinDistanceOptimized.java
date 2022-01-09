/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levenshteindistance;

/**
 * Time Complexity: O(n*m) and Space Complexity: O(min(n,m)) where n and m 
 * are the length of string 1 and 2 respectively
 * @author souravpalit
 */
public class LevenshteinDistanceOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";
        
        System.out.println("Levenshtein Distance : " + calculateLevenshteinDistance(str1, str2));
    }
    
    public static int calculateLevenshteinDistance(String str1, String str2) {
        String small = str1.length() < str2.length() ? str1 : str2;
        String big = str1.length() >= str2.length() ? str1 : str2;
        
        int [] evenEdits = new int [small.length() + 1];
        int [] oddEdits = new int [small.length() + 1];
        
        
        for (int i = 0; i < evenEdits.length; i++) {
            evenEdits[i] = i;
        }
        
        int [] currentEdits;
        int [] previousEdits;
        
        for (int row = 1; row < big.length() + 1; row++) {
            
            if (row % 2 == 1) {
                previousEdits = evenEdits;
                currentEdits = oddEdits;
            } else {
                previousEdits = oddEdits;
                currentEdits = evenEdits;
            }
            
            currentEdits[0] = row;
            
            for (int col = 1; col < small.length() + 1; col++) {
                if (big.charAt(row - 1) == small.charAt(col - 1)) {
                    currentEdits[col] = previousEdits[col - 1];
                } else {
                    currentEdits[col] = 1 + 
                            Math.min(previousEdits[col - 1], Math.min(previousEdits[col], currentEdits[col - 1]));
                }
            }
        }
        
        return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
    }
    
}
