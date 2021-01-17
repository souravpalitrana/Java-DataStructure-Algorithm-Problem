/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suffixtrieconstruction;

/**
 *
 * @author souravpalit
 */
public class SuffixTrieConstruction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String [] words = {"Hello", "I", "am", "Sourav"};
        SuffixTrie suffixTrie = new SuffixTrie();
        
        for (int i = 0 ; i < words.length; i++) {
            suffixTrie.add(words[i]);
        }
        
        String [] testWords = {"Hello", "I", "am", "Sourav", "Palit"};
        for (int i = 0; i < testWords.length; i++) {
            System.out.println("'" + testWords[i] + "'" + " Contains in SuffixTree: " + suffixTrie.contains(testWords[i]));
        }
    }
    
}
