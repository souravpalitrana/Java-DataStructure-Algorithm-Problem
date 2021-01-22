/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SuffixTrie Solution
 * For constructing suffix trie Time Complexity O(b^2) where b is the big 
 * string length and space for suffix trie is O(b^2). Now to search n word
 * in the suffix tree time complexity is O(ns) where s it the highest small 
 * word length so total Time Complexity is O(b^2 + ns) and space complexity
 * is O(b^2 + n) here n is for storing n result
 * @author souravpalit
 */
public class MultiStringSearchFirstOptimization {

    /**
     
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String bigString = "this is a big string";
        //String bigString = "abcdefghijklmnopqrstuvwxyz";
        String [] smallString = {"this", "yo", "is", "a", "bigger", "string", "appa"};
        
        //String [] smallString = {"abc", "mnopqr", "wyz", "no", "e", "tuuv"};
        
        List<Boolean> result = multiStringSearch(bigString, smallString);
        
        for (Boolean value : result) {
            System.out.print(value + "   ");
        }
    }
    
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

        SuffixTrie suffixTrie = new SuffixTrie();

        List<Boolean> searchResult = new ArrayList<Boolean>();

        suffixTrie.add(bigString);

        for (int i = 0; i < smallStrings.length; i++) {
            searchResult.add(suffixTrie.contains(smallStrings[i]));
        }

        return searchResult;
    }
    
}
