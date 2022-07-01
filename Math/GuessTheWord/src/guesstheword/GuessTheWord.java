/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesstheword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Leetcode: 843. Guess the Word
 * Problem Link: https://leetcode.com/problems/guess-the-word/
 * @author souravpalit
 */
public class GuessTheWord {

    // Time Complexity: O(10n) = O(n) 
    // Space Complexity: O(10n) = O(n)
    public void findSecretWord(String[] wordlist, Master master) {
        Random rand = new Random();
        List<String> wordList = Arrays.asList(wordlist);
        
        while (wordList.size() > 1) {
            int randomIdx = rand.nextInt(wordList.size());
            String queryString = wordList.get(randomIdx);
            int queryScore = master.guess(queryString);
            wordList = filterWords(queryString, queryScore, wordList);
        }
        
        master.guess(wordList.get(0));
    }
    
    public List<String> filterWords(String query, int queryScore, List<String> wordList) {
        List<String> result = new ArrayList<>();
        
        for (String word : wordList) {
            if (queryScore == calculateScore(query, word)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    public int calculateScore(String query, String candidate) {
        int score = 0;
        for (int i = 0; i < query.length(); i++) {
            
            score += query.charAt(i) == candidate.charAt(i) ? 1 : 0;
        }
        return score;
    }
    
}
