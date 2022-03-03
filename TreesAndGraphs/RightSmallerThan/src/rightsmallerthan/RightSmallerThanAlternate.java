/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rightsmallerthan;

import java.util.ArrayList;
import java.util.List;

/**
 * Average Time Complexity: O(nlogn) and Space Complexity: O(N) 
 * Worst Time complexity: O(n^2) when BST is left aligned or right aligned
 * @author souravpalit
 */
public class RightSmallerThanAlternate {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> input = new ArrayList();
        
        /*input.add(8);
        input.add(5);
        input.add(2);
        input.add(9);
        input.add(5);
        input.add(6);
        input.add(3);*/
        
        input.add(8);
        input.add(5);
        input.add(11);
        input.add(-1);
        input.add(3);
        input.add(4);
        input.add(2);
        
        /*input.add(0);
        input.add(1);
        input.add(1);
        input.add(1);
        input.add(2);*/
        
        List<Integer> output = rightSmallerThan(input);
        
        for (Integer value : output) {
            System.out.print(value + " ");
        }
    }
    
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) return new ArrayList<Integer>();
        int lastIdx = array.size() - 1;
        BSTAlternate bst = new BSTAlternate(array.get(lastIdx), lastIdx, 0);
        
        for (int i = lastIdx - 1; i >= 0; i--) {
            bst.insert(array.get(i), i);
        }
        
        List<Integer> result = new ArrayList<Integer>(array);
        getSmallerCount(bst, result);
        return result;
    }
    
    public static void getSmallerCount(BSTAlternate bst, List<Integer> result) {
        if (bst == null) return;
        
        result.set(bst.idx, bst.numberOfSmallerAtInsertTime);
        getSmallerCount(bst.left, result);
        getSmallerCount(bst.right, result);
    }
}
