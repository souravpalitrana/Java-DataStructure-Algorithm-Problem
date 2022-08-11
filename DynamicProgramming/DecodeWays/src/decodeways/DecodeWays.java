/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodeways;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode: 91. Decode Ways
 * Problem Link: https://leetcode.com/problems/decode-ways/
 * @author souravpalit
 */
public class DecodeWays {

    private Map<Integer, Integer> cache;
    
    // TC: O(N) SC:(N)
    public int numDecodings(String s) {
        cache = new HashMap<>();
        return numOfWays(0, s);
    }
    
    private int numOfWays(int position, String s) {
        if (position >= s.length() || s.charAt(position) == '0') {
            return position == s.length() ? 1 : 0;
        } else if (cache.containsKey(position)) {
            return cache.get(position);
        }
        
        int ways = numOfWays(position + 1, s);
        if (position < s.length() - 1) {
            String digitInString = s.substring(position, position + 2);
            int digit = Integer.parseInt(digitInString);
            if (digit <= 26) {
                ways += numOfWays(position + 2, s);
            }
        }
        
        cache.put(position, ways);
        return ways;
    }
    
}
