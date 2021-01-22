/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringsearch;

/**
 *
 * @author souravpalit
 */
public class Trie {
    public TrieNode root = new TrieNode();
    public char endSymbol = '*';
    
    public void add(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        TrieNode endNode = new TrieNode();
        endNode.word = word;
        node.children.put(endSymbol, endNode);
    }
}
