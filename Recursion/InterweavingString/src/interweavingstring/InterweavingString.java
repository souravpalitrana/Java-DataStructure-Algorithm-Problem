/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interweavingstring;

/**
 *
 * @author souravpalit
 */
public class InterweavingString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String one = "algoexpert";
        String two = "your-dream-job";
        String three = "your-algodream-expertjob";
        
        //System.out.println(isInterweavingString(one, two, three));
        
        long startTimeWithoutMemorization = System.currentTimeMillis();
        
        boolean result = isInterweavingString(one, two, three);
        
        long endTimeWithoutMemorization = System.currentTimeMillis();
        
        System.out.println("Is Interweaving String: " + result + " Execution Time:" + (endTimeWithoutMemorization - startTimeWithoutMemorization));
        
        long startTimeWithMemorization = System.currentTimeMillis();
        
        boolean resultWithMemo = isInterweavingStringUsingMemorization(one, two, three);
        
        long endTimeWithMemorization = System.currentTimeMillis();
        
        System.out.println("Is Interweaving String: " + resultWithMemo + " Execution Time:" + (endTimeWithMemorization - startTimeWithMemorization));
        
    }
    
    // Time Complexity: O(2^(n+m)) & Space Complexity O(n+m) because of recursion stack
    public static boolean isInterweavingString(String one, String two, String three) {
        if (one.length() + two.length() != three.length()) {
            return false;
        }
        
        return isInterweavingString(one, two, three, 0, 0);
    }
    
    // Without Memorization
    public static boolean isInterweavingString(String one, String two, String three, int i, int j) {
        int k = i + j;
        
        if (k == three.length()) {
            return true;
        }
        
        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            if (isInterweavingString(one, two, three, i + 1, j)) {
                return true;
            }
        }  
        
        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            if (isInterweavingString(one, two, three, i, j + 1)) {
                return true;
            }
        } 
        
        return false;
        
    }
    
    // Time Complexity: O(nm) & Space Complexity: O(nm) because of the cache
    public static boolean isInterweavingStringUsingMemorization(String one, String two, String three) {
        if (one.length() + two.length() != three.length()) {
            return false;
        }
        Boolean [][] cache = new Boolean[one.length() + 1][two.length() + 1];
        return isInterweavingString(one, two, three, 0, 0, cache);
        
    }
    
    // With Memorization
    public static Boolean isInterweavingString(String one, String two, String three, int i, int j, Boolean [][] cache) {
        int k = i + j;
        
        if (k == three.length()) {
            return true;
        } else if (cache[i][j] != null) {
            return cache[i][j];
        }
        
        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            cache[i][j] = isInterweavingString(one, two, three, i + 1, j, cache);
            if (cache[i][j]) {
                return true;
            }
        }  
        
        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            cache[i][j] = isInterweavingString(one, two, three, i, j + 1, cache);
            if (cache[i][j]) {
                return true;
            }
        } 
        
        cache[i][j] = false;
        return cache[i][j];
    }
    
    
    
}
