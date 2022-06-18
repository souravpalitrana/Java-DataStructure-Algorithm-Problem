/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefixandsuffixsearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
class Trie {

    public TrieNode root = new TrieNode();

    public void addWords(String[] words) {
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], i);
        }
    }

    private void addWord(String word, int idx) {
        TrieNode currentNode = root;

        for (char ch : word.toCharArray()) {
            int nodeIdx = ch - 'a';

            if (currentNode.children[nodeIdx] == null) {
                currentNode.children[nodeIdx] = new TrieNode();
                currentNode.children[nodeIdx].ch = ch;
            }

            currentNode = currentNode.children[nodeIdx];
        }

        currentNode.word = word;
        currentNode.isWord = true;
        currentNode.idx = idx;
    }

    public int searhWord(String prefix, String suffix) {
        TrieNode current = root;
        int wordIdx = -1;;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return wordIdx;
            }
            current = current.children[idx];
        }
        
        if (current.isWord && current.word.endsWith(suffix)) {
            return current.idx;
        } else if (current.isWord) {
            return wordIdx;
        }

        for (TrieNode trieNode : current.children) {
            if (trieNode != null) {
                int idx = searchSuffix(trieNode, suffix, 0);
                wordIdx = Math.max(idx, wordIdx);
            } 
        }

        return wordIdx;
    }

    private int searchSuffix(TrieNode trieNode, String suffix, int position) {
        if (position >= suffix.length() || trieNode == null) {
            return -1;
        }
        int idx = suffix.charAt(position) - 'a';
        TrieNode child = trieNode.children[idx];
        if (child != null && child.isWord && position >= suffix.length() - 1) {
            return child.idx;
        }

        int maxWordIdx = -1;

        for (int i = 0; i < 26; i++) {
            TrieNode node = trieNode.children[i];
            if (node == null) {
                continue;
            }
                       
            int first = Math.max(maxWordIdx, searchSuffix(node, suffix, position + 1));
            int second = Math.max(maxWordIdx, searchSuffix(node, suffix, position));
            first = Math.max(first, second);
            maxWordIdx = Math.max(first, maxWordIdx);;
        }
  
        return maxWordIdx;
    }
}
