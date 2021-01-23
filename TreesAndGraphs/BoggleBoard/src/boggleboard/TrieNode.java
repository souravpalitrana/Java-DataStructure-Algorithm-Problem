/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggleboard;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class TrieNode {
    
    public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public String word;
}
