/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rightsmallerthan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * If input is [8,5 11,-1, 3,4,2] then output will be [5,4,4,0,1,1,0] Here
 * there is 5 value after 8 which are smaller than 8, 4 value which are smaller than
 * 5, 4 value smaller than 11 so on.
 * Time Complexity: O(NLogN) and Space Complexity: O(N)
 * @author souravpalit
 */
public class RightSmallerThanOptimized {

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
        input.add(6);
        input.add(8);
        input.add(5);
        
        /*input.add(8);
        input.add(5);
        input.add(11);
        input.add(-1);
        input.add(3);
        input.add(4);
        input.add(2);*/
        
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
        BST bst = new BST(array.get(array.size() - 1));
        ArrayList<Integer> rightSmallerCounts = new ArrayList<>();
        rightSmallerCounts.add(0);
        
        for (int i = array.size() - 2; i >= 0; i--) {
            int input = array.get(i);
            int output = bst.insert(input);
            rightSmallerCounts.add(output);
        }
        
        Collections.reverse(rightSmallerCounts);
        
        return rightSmallerCounts;
    }
}
