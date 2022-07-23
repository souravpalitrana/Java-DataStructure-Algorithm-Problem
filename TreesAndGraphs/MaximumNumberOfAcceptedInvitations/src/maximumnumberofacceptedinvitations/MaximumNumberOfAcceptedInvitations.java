/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumnumberofacceptedinvitations;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class MaximumNumberOfAcceptedInvitations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] grid = {
            {1,1,1},
            {1,0,1},
            {0,0,1}};
        System.out.println(maximumInvitations(grid));
    }
    
    
    public static int maximumInvitations(int[][] grid) {
        int m = grid.length; // boys
        int n = grid[0].length; // girls

        int[] girlFixed = new int[n];

        for (int i = 0; i < n; i++) {
            girlFixed[i] = -1;
        }

        int invitations = 0;

        for (int i = 0; i < m; i++) {
            Set<Integer> seenGirl = new HashSet<>();

            if (dfs(grid, i, seenGirl, girlFixed)) {
                invitations++;
            }
        }
        return invitations;
    }

    private static boolean dfs(int[][] grid, int boy, Set<Integer> seenGirl, int[] girlFixed) {
        int m = grid.length; // boys
        int n = grid[0].length; // girls

        for (int i = 0; i < n; i++) {
            if (grid[boy][i] == 1 && !seenGirl.contains(i)) {
                seenGirl.add(i);
                if (girlFixed[i] == -1 || dfs(grid, girlFixed[i], seenGirl, girlFixed)) {
                    girlFixed[i] = boy;
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
