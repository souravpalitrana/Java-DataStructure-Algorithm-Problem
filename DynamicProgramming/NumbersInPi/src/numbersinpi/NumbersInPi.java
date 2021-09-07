/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbersinpi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Time Complexity: O(n^3 + m) and Space Complexity: O(n + m) where n is the 
 * length of pi and m is the numbers length
 * @author souravpalit
 */
public class NumbersInPi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pi = "3141592653589793238462643383279";
        String[] numbers = new String[] { "314159265358979323846", "26433", "8", 
            "3279", "314159265", "35897932384626433832", "79"};
        System.out.println(getMinSpaces(pi, numbers));
        
    }
    
    public static int getMinSpaces(String pi, String [] numbers) {
        Set<String> numbersTable = transform(numbers);
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        int minSpaces = getMinSpaces(pi, numbersTable, cache, 0);
        return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
    }
    
    public static int getMinSpaces(String pi, Set<String> numbersTable, Map<Integer, Integer> cache, int idx) {
        if (idx >= pi.length()) return -1;
        if (cache.containsKey(idx)) return cache.get(idx);
        
        int minSpaces = Integer.MAX_VALUE;
        for (int i = idx; i < pi.length(); i++) {
            String prefix = pi.substring(idx, i + 1);
            if (numbersTable.contains(prefix)) {
                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
                
                if (minSpacesInSuffix != Integer.MAX_VALUE) {
                    minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
                }
            }
        }
        cache.put(idx, minSpaces);
        return minSpaces;
    }
    
    public static Set<String> transform(String [] numbers) {
        Set<String> numbersTable = new HashSet<String>(); 
        for (String value : numbers) {
            numbersTable.add(value);
        }
        
        return numbersTable;
    }
    
}
