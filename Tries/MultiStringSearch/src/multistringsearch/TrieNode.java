/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringsearch;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    // Will use for the optimize solution
    String word;
}
