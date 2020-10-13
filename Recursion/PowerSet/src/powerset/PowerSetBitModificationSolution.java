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
           
        
       /* ArrayList<ArrayList<String>> allSubsets = getSubsets(set, 0);
        
        for (ArrayList<String> subset : allSubsets) {
            
            if (subset.size() == 0) {
                System.out.println("{}");
            } else {
                System.out.print("{");
                for (String element : subset) {
                    System.out.print(" " + element + " ");
                }
                System.out.println("}");
            }
            
        }*/
    }
    
    private static ArrayList<ArrayList<String>> getSubsets(ArrayList<String> set, int index) {
        ArrayList<ArrayList<String>> allSubsets;
        
        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            String item = set.get(index);
            ArrayList<ArrayList<String>> moreSubsets = new ArrayList<>();
            
            for (ArrayList<String> subset : allSubsets) {
                ArrayList<String> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            
            allSubsets.addAll(moreSubsets);
        }
        
        return allSubsets;
    } 
}
