/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Using Trie. Constructing trie time complexity O(ns) where n is the number of
 * small string and s is the highest length of a small string and space complexity
 * is also O(ns). Now for searching it is O(bs) because we are iterating the whole
 * big string where b is the big string length and for matching each word we need
 * to do maximum s operation where s is the highest length of a small word. So
 * total time complexity is O(ns+ bs) and space complexity O(ns + n) which is O(ns)
 * @author souravpalit
 */
public class MultiStringSearchSecondOptimization {
    
    public static void main(String args []) {
        //String bigString = "this is a big string";
        String bigString = "abcdefghijklmnopqrstuvwxyz";
        //String [] smallString = {"this", "yo", "is", "a", "bigger", "string", "kappa"};
        String [] smallString = {"abcdefghijklmnopqrstuvwxyz", "abc"};
        
         List<Boolean> result = multiStringSearch(bigString, smallString);
        
        for (Boolean value : result) {
            System.out.print(value + "   ");
        }
    }
    
    public static List<Boolean> multiStringSearch(String bigString, String [] smallWords) {
        List<Boolean> result = new ArrayList<Boolean>();
        Trie trie = new Trie();
        for (int i = 0; i < smallWords.length; i++) {
            trie.add(smallWords[i]);
        }
        
        List<String> wordContainsInBigString = new ArrayList<String>();
        for (int i = 0; i < bigString.length(); i++) {
            findWordInBigString(bigString, trie, i, wordContainsInBigString);
        }
        
        
        for (int i = 0; i < smallWords.length; i++) {
            result.add(wordContainsInBigString.contains(smallWords[i]));
        }
        
        return result;
    }
    
    public static void findWordInBigString(String str, Trie trie, 
            int startPosition, List<String> wordContainsInBigString) {
        TrieNode node = trie.root;
        
        for (int i = startPosition; i <str.length(); i++) {
            char letter = str.charAt(i);
            
            if (!node.children.containsKey(letter)) {
                // This letter does not contains in our search word so we don't 
                // need to check further
                break;
            }
            node = node.children.get(letter);
            
            if (node.children.containsKey(trie.endSymbol)) {
                wordContainsInBigString.add(node.children.get(trie.endSymbol).word);;
            }
        }
    }
}
