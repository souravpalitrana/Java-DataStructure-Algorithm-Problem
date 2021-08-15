/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofwaystosolvegraph;

/**
 * Time Complexity: O(n+m) because of numerator factorial count
 * Space Complexity: O(1)
 * @author souravpalit
 */
public class NumberOfWaysToSolveGraphOptimized {
    
    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        System.out.println(numberOfWaysToTraverseGraph(width, height));
    }
    
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        // law (width + height)! / width! * height!
        int xDistanceToCorner = width - 1;
        int yDistanceToCorner = height - 1;
        
        int numerator = factorial(xDistanceToCorner + yDistanceToCorner);
        int dinominator = factorial(xDistanceToCorner) * factorial(yDistanceToCorner);
        
        return numerator / dinominator;
    }
    
    public static int factorial(int n) {
        int result = 1;
        
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }
    
}
