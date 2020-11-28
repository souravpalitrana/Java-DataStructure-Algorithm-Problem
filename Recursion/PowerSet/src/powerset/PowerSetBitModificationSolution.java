/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerset;

import java.util.ArrayList;

/**
 * Power Set: Write a method to return all subsets of a set. 
 * @author souravpalit
 */
public class PowerSetBitModificationSolution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> set = new ArrayList<>(); 
        set.add("a");
        set.add("b");
        set.add("c");
        
        for (int i = 0; i < 1 << set.size(); i++) {
            System.out.print("{");
            for (int j = 0; j < set.size(); j++) {
                if ((i & (1 << j)) > 0) {
                     System.out.print(set.get(j));
                }
            }
            System.out.println("}");
        } 
    }
}
