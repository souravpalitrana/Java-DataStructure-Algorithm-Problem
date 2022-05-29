/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumproductofwordlengths;

/**
 *
 * @author souravpalit
 */
public class MaximumProductOfWordLengths {

    /**
     * Approach 1: Brute Force
     * Time Complexity: (N^2 * L^2) where N is the number of words and L is 
     * the max length
     */
    public int maxProduct(String[] words) {
        int maxProduct = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasMatchingCharacter(words[i], words[j])) {
                    int product = words[i].length() * words[j].length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        
        return maxProduct;
    }
    
    public boolean hasMatchingCharacter(String word1, String word2) {
        for (char ch : word1.toCharArray()) {
            if (word2.indexOf(ch) != -1) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Approach 2: Bitmasking to Reduce L^2 to L1 + L2 where L1 and L2 are the 
     * length of the two string
     */
    public int maxProductAlternate1(String[] words) {
        int maxProduct = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasMatchingCharacterAlternate(words[i], words[j])) {
                    int product = words[i].length() * words[j].length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        
        return maxProduct;
    }
    
    public boolean hasMatchingCharacterAlternate(String word1, String word2) {
        int bitmask1 = 0, bitmask2 = 0;
        
        for (char ch : word1.toCharArray()) {
            bitmask1 |= 1 << (ch - 'a');
        }
        
        for (char ch : word2.toCharArray()) {
            bitmask2 |= 1 << (ch - 'a');
        }
        
        return (bitmask1 & bitmask2) != 0;
    }
    
    /**
     * Approach 3: Precomputation + bit mask and constant matching
     * Time Complexity: O(NL + N^2)
     */
    public int maxProductAlternate2(String[] words) {
        int maxProduct = 0;
        int [] bitmasks = new int [words.length];
        for (int i = 0; i < words.length; i++) {
            bitmasks[i] = generateBitmask(words[i]);
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitmasks[i] & bitmasks[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        
        return maxProduct;
    }
    
    public int generateBitmask(String word) {
        int bitmask = 0;
        
        for (char ch : word.toCharArray()) {
            bitmask |= 1 << (ch - 'a');
        }
        
        return bitmask;
    }
    
}
