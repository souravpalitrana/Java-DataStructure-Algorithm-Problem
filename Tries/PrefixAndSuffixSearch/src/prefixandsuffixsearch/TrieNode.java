/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefixandsuffixsearch;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class TrieNode {
    char ch;
    public TrieNode [] children = new TrieNode[26];
    public String word;
    public boolean isWord;
    public int idx = -1;
}
