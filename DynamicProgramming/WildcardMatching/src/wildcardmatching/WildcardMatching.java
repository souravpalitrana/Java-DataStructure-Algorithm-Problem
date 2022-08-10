/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildcardmatching;

/**
 * Leetcode: 44. Wildcard Matching
 * Problem Link: https://leetcode.com/problems/wildcard-matching/
 * @author souravpalit
 */
public class WildcardMatching {

    private Boolean [][] cache;
    private String s, p;
    
    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length() + 1][p.length() + 1];
        this.s = s;
        this.p = p;
        return isMatch(0, 0);
    }
    
    private boolean isMatch(int idxS, int idxP) {
        if (idxP == p.length()) {
            cache[idxS][idxP] = idxS == s.length();
            return idxS == s.length();
        } else if (cache[idxS][idxP] != null) {
            return cache[idxS][idxP];
        }
        
        boolean result = false;
        
        if (p.charAt(idxP) == '*') {
            result = isMatch(idxS, idxP + 1) || idxS < s.length() && isMatch(idxS + 1, idxP);
        } else {
            boolean isInitialMatched = idxS < s.length() && 
            (s.charAt(idxS) == p.charAt(idxP) || p.charAt(idxP) == '?');
            result = isInitialMatched && isMatch(idxS + 1, idxP + 1) ;
        }
        cache[idxS][idxP] = result;
        return result;
    }
    
}
