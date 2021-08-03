/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofwaystosolvegraph;

/**
 * Time Complexity: O(n * m) Space Complexity: O(n * m)
 * @author souravpalit
 */
public class NumberOfWaysToSolveGraphIterative {
    
    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        System.out.println(numberOfWaysToTraverseGraph(width, height));
    }
    
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int [][] ways = new int [height + 1][width + 1];
        
        for (int widthIdx = 1; widthIdx < width + 1; widthIdx++) {
            for (int heightIdx = 1; heightIdx < height + 1; heightIdx++) {
                if (widthIdx == 1 || heightIdx == 1) {
                    ways[heightIdx][widthIdx] = 1;
                } else {
                    ways[heightIdx][widthIdx] = ways[heightIdx][widthIdx - 1] + ways[heightIdx - 1][widthIdx];
                }
            }
        }
        
        return ways[height][width];
    }
}
