/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confusingnumberii;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class ConfusingNumberII {

    public int confusingNumberII(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        return rec(map, 0, 0, 1, n);        
    }
    
    private int rec(Map<Integer, Integer> map, int num, int rotatedNum, int base, int n) {
        if (num > n || num < 0) return 0;
        int count = num != rotatedNum && num != 0 ? 1 : 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((num == 0 && entry.getKey() == 0) || num > 100000000) continue; 
            count += rec(map, num * 10 + entry.getKey(), entry.getValue() * base + rotatedNum, base * 10, n);
        }
        return count;
    }
    
}
