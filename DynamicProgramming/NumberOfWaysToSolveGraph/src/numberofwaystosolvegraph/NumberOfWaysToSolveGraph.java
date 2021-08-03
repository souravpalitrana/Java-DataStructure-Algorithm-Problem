/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofwaystosolvegraph;

/**
 * Time Complexity: O(2^(n + m)) Space Complexity: O(n + m)
 * @author souravpalit
 */
public class NumberOfWaysToSolveGraph {
    
    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        System.out.println(numberOfWaysToTraverseGraph(width, height));
    }
    
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        return numberOfWaysToTraverseGraph(0, 0, height, width);
    }
    
    public static int numberOfWaysToTraverseGraph(int row, int col, int actualRow, int actualCol) {
        if (row == actualRow - 1 && col == actualCol - 1) {
            return 1;
        }
        
        int ways = 0;
        
        if (canMoveToNext(row, col + 1, actualRow, actualCol)) {
            ways += numberOfWaysToTraverseGraph(row, col + 1, actualRow, actualCol);
        }
        
        if (canMoveToNext(row + 1, col, actualRow, actualCol)) {
            ways += numberOfWaysToTraverseGraph(row + 1, col, actualRow, actualCol);
        }
        
        return ways;
    }
    
    public static boolean canMoveToNext(int row, int col, int actualRow, int actualCol) {
        return row < actualRow && col < actualCol;
    }
}
