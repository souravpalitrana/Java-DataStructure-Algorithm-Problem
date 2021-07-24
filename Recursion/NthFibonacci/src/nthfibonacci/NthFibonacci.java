/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nthfibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class NthFibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 6;
        System.out.println(getNthFib(n));
        System.out.println(getNthFibUsingMemorization(n));
        System.out.println(getNthFibUsingLoop(n));
    }
    
    // Time Complexity: O(2^n) & space Complexity O(n)
    public static int getNthFib(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        
        return getNthFib(n - 1) + getNthFib(n - 2);
    }
    
    // Time Complexity: O(n) and Space Complexity O(n)
    public static int getNthFibUsingMemorization(int n) {
        Map<Integer, Integer> memorize = new HashMap<Integer, Integer>();
        memorize.put(0, 0);
        memorize.put(1, 0);
        memorize.put(2, 1);
        return getNthFibUsingMemorization(n, memorize);
    }
    
    private static int getNthFibUsingMemorization(int n, Map<Integer, Integer> memorize) {
        if (memorize.containsKey(n)) {
            return memorize.get(n);
        } else {
            int value = getNthFibUsingMemorization(n - 1, memorize) + getNthFibUsingMemorization(n - 2, memorize);
            memorize.put(n, value);
            return value;
        }
    }
    
    // Time Complexity: O(n) Space Complexity: O(1)
    public static int getNthFibUsingLoop(int n) {
        int n1 = 0;
        int n2 = 1;
        if (n <= 1) return n1;
        if (n == 2) return n2;
        
        int nthValue = 0;
        for (int i = 3; i <= n; i++) {
             nthValue = n1 + n2;
             n1 = n2;
             n2 = nthValue;
        }
        
        return nthValue;
    }
}
