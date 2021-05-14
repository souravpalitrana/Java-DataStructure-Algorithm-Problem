/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time complexity: O(w * nlogn) where w is the number of words and to sort each
 * word we need nlogn time so total w*nlogn
 * Space complexity: O(wn) where w is the number of words and n is the length of 
 * the longest word
 * @author souravpalit
 */
public class GroupAnagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>();
        String [] words = {"yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"};
        wordList.addAll(Arrays.asList(words));
        List<List<String>> anagrams = groupAnagrams(wordList);
        
        for (List<String> anagram : anagrams) {
            System.out.print("[");
            for (String word : anagram) {
                System.out.print(word + " ");
            }
            System.out.print("]");
        }
    }
    
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String,List<String>> anagrams = new HashMap<String, List<String>>();
        
        for (String word : words) {
            char [] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            
            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                List<String> wordList = new ArrayList<String>();
                wordList.add(word);
                anagrams.put(sortedWord, wordList);
            }
        }
        
        return new ArrayList<>(anagrams.values());
    }
    
}
