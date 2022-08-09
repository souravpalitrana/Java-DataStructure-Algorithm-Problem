/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regularexpressionmatching;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 * 10. Regular Expression Matching
 * Leetcode: https://leetcode.com/problems/regular-expression-matching/
 * @author souravpalit
 */
public class RegularExpressionMatching {

    private Map<Pair, Boolean> cache;
    private String s, p;
    
    // TC: O(SP) where S and P is the length of S and P
    // SC: O(SP)
    public boolean isMatch(String s, String p) {
        cache = new HashMap<>();
        this.s = s;
        this.p = p;
        return isMatch(0, 0);
    }
    
    public boolean isMatch(int idxS, int idxP) {
        Pair pair = new Pair(idxS, idxP);
        if (idxP == p.length()) {
            cache.put(pair, idxS == s.length());
            return idxS == s.length();
        } else if (cache.containsKey(pair)) {
            return cache.get(pair);
        }
        
        boolean isMatched = (idxS < s.length() && (s.charAt(idxS) == p.charAt(idxP) || p.charAt(idxP) == '.'));        
        boolean result;
        
        if (idxP + 1 < p.length() && p.charAt(idxP + 1) == '*') {
            // Skip the start or take multiple of the matching character
            result = isMatch(idxS, idxP + 2) || (isMatched && isMatch(idxS + 1, idxP));
        } else {
            result = isMatched && isMatch(idxS + 1, idxP + 1);
        }
        
        cache.put(pair, result);
        return result;
    }
    
}
