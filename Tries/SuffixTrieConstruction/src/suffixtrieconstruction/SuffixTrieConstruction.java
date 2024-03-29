/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suffixtrieconstruction;

/**
 * Creating Suffix tree Time Complexity: O(n^2) Space Complexity O(n^2)
 * Searching String Time Complexity: O(m) where m is the string length and
 * Space Complexity: O(1) as no extra space is using.
 * @author souravpalit
 */
public class SuffixTrieConstruction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        //String [] words = {"this", "is", "a", "big", "string"};
        String [] words = {"this"};
        SuffixTrie suffixTrie = new SuffixTrie();
        
        for (int i = 0 ; i < words.length; i++) {
            suffixTrie.add(words[i]);
        }
        
        //String [] testWords = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        String [] testWords = {"this", "is"};
        for (int i = 0; i < testWords.length; i++) {
            System.out.println("'" + testWords[i] + "'" + 
                    " Contains in SuffixTree: " + suffixTrie.contains(testWords[i]));
        }
    }
    
}
