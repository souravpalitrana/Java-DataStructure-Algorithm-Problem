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
public class PowerSetAlternate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> set = new ArrayList<>(); 
        set.add("a");
        set.add("b");
        set.add("c");
        ArrayList<ArrayList<String>> moreSubsets = new ArrayList<>();
        moreSubsets.add(new ArrayList<String>());
        ArrayList<ArrayList<String>> allSubsets = getSubsets(set,moreSubsets, 0);
        
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
            
        }
    }
    
    private static ArrayList<ArrayList<String>> getSubsets(ArrayList<String> set, 
            ArrayList<ArrayList<String>> allSubsets, int index) {
        if (index < set.size()) {
            String item = set.get(index);
            ArrayList<ArrayList<String>> moreSubsets = new ArrayList<>();
            
            for (ArrayList<String> subset : allSubsets) {
                ArrayList<String> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            
            allSubsets.addAll(moreSubsets);
            
            getSubsets(set, allSubsets, index + 1);
        } 
        
        return allSubsets;
    } 
}
