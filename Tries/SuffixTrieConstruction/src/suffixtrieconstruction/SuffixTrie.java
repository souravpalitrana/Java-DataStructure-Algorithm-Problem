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
public class SuffixTrie {
    
    TrieNode root = new TrieNode();
    Character endSymbol = '*';
    
    public void add(String str) { 
        for (int i = 0; i < str.length(); i++) {
            insertInSuffixTrie(i, str);
        }
    }
    
    public boolean contains(String str) {
        TrieNode node = root;
        
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        
        return node.children.containsKey(endSymbol);
    }
    
    private void insertInSuffixTrie(int position, String str) {
        TrieNode node = root;
        
        for (int i = position; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!node.children.containsKey(letter)) {
                node.children.put(str.charAt(i), new TrieNode());
            }
            node = node.children.get(letter);
        }
        
        node.children.put(endSymbol, null);
    }
    
}
