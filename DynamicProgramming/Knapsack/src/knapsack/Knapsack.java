/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(nc) and Space Complexity: O(nc) where n is the 
 * number of items and c is the capacity
 * @author souravpalit
 */
public class Knapsack {

    public static void main(String[] args) {
        int[][] items = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int capacity = 10;
        List<List<Integer>> result = knapsackProblem(items, capacity);
        
        System.out.println("Max Value : " + result.get(0).get(0));
        
        System.out.print("Item Index : [ ");
        
        for (Integer itemIdx : result.get(1)) {
            System.out.print(itemIdx + " ");
        }
        
        System.out.println(" ]");
    }
    
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int [][] knapsack = new int [items.length + 1][capacity + 1];
        
        Arrays.fill(knapsack[0], 0);
        
        for (int i = 0; i < knapsack.length; i++) {
            knapsack[i][0] = 0;
        }
        
        for (int row = 1; row < knapsack.length; row++) {
            for (int col = 1; col < knapsack[0].length; col++) {
                int value = items[row - 1][0];
                int weight = items[row - 1][1];
                
                if (weight > col) {
                    // We need to exclude the current
                    knapsack[row][col] = knapsack[row - 1][col];
                } else {
                    int byTakingTheCurrent = value + knapsack[row - 1][col - weight];
                    int withoutTakingTheCurrent = knapsack[row - 1][col];
                    knapsack[row][col] = Math.max(byTakingTheCurrent, withoutTakingTheCurrent);
                }
            }
        }
        
        List<Integer> maxValueList = new ArrayList<Integer>();
        maxValueList.add(knapsack[items.length][capacity]);
        
        List<Integer> itemIndexList = getItemList(knapsack, items);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(maxValueList);
        result.add(itemIndexList);
        
        
        return result;
    }
    
    public static List<Integer> getItemList(int [][] knapsack, int[][] items) {
        List<Integer> indexList = new ArrayList<Integer>();
        int row = knapsack.length - 1;
        int col = knapsack[0].length - 1;
        
        while (row > 0 && col > 0) {
            if (knapsack[row][col] == knapsack[row - 1][col]) {
                row--;
            } else {
                indexList.add(0, row - 1); // as we added extra row for 0
                col = col - items[row - 1][1];
                row--;
            }
        }
        
        return indexList;
    }
   
}
