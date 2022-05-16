/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpathinbinarymatrix;

/**
 *
 * @author souravpalit
 */
public class ShortestPathInBinaryMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ShortestPathInBinaryMatrixSolution solution = new ShortestPathInBinaryMatrixSolution();
        
        /*int [][] grid = {
            {0,0,1,1,1},
            {1,0,0,0,1}, 
            {1,0,1,1,1}, 
            {1,0,0,0,0}, 
            {1,1,1,1,0}
        };*/
        
        int [][] grid = {
            {0,0,0,0,1},
            {1,0,0,0,0}, 
            {0,1,0,1,0}, 
            {0,0,0,1,1}, 
            {0,0,0,1,0}
        };
        
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }
    
}
