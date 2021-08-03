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
public class NumberOfWaysToSolveGraphAlternate {
    
    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        System.out.println(numberOfWaysToTraverseGraph(width, height));
    }
    
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        if (width == 1 || height == 1) {
            return 1;
        }
        return numberOfWaysToTraverseGraph(width - 1, height) + 
                numberOfWaysToTraverseGraph(width, height - 1);
    }
}
