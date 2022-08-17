/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordbreakii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode: 140. Word Break II
 * Problem Link: https://leetcode.com/problems/word-break-ii/
 * @author souravpalit
 */
public class WordBreakII {

    private Map<Integer, List<String>> cache;
    private String s;
    private Trie trie;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        cache = new HashMap<>();
        this.s = s;
        trie = new Trie();
        for (String word : wordDict) {
            trie.addWord(word);
        }
        
        return findSentences(0);
    }
    
    private List<String> findSentences(int pos) {
        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }
        
        TrieNode currentNode = trie.root;
        List<String> sentences = new ArrayList();
        
        for (int i = pos; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!currentNode.children.containsKey(ch)) {
                break;
            }
            
            currentNode = currentNode.children.get(i);
          
            
            if (currentNode.children.containsKey(trie.endSymbol)) {
                String word = s.substring(pos, i + 1);
                if (i == s.length() - 1) {
                    sentences.add(word);
                } else {
                    List<String> nextSentences = findSentences(i + 1);
                    for (String sentence : nextSentences) {
                        sentences.add(word + " " + sentence);
                    }
                }
            }
        }
        
        cache.put(pos, sentences);
        return sentences;
    }
    
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    class Trie {
        TrieNode root;
        char endSymbol = '*';
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void addWord(String word) {
            TrieNode currentNode = root;
            
            for (char ch : word.toCharArray()) {
                if (!currentNode.children.containsKey(ch)) {
                    currentNode.children.put(ch, new TrieNode());
                }
                currentNode = currentNode.children.get(ch);
            }
            
            currentNode.children.put(endSymbol, null);
        }
    }
}
