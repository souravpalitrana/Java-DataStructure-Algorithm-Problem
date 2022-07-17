/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallsandgates;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode: 286. Walls and Gates
 * Problem Link: https://leetcode.com/problems/walls-and-gates/
 * @author souravpalit
 */
public class WallsAndGates {

    int [] directions = {-1, 0, 1, 0, -1};
    
    // TC: O(mn) SC: O(mn)
    public void wallsAndGates(int[][] rooms) {
        Queue<CellInfo> queue = new LinkedList<>();
        
        // Add the door in the queue
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == 0) {
                    queue.add(new CellInfo(row, col));
                }
            }
        }
        
        while (!queue.isEmpty()) {
            CellInfo cellInfo = queue.remove();
            
            for (int i = 0; i < directions.length - 1; i++) {
                int newRow = cellInfo.row + directions[i];
                int newCol = cellInfo.col + directions[i + 1];
                
                if (newRow < 0 || newCol < 0 || newRow >= rooms.length 
                    || newCol >= rooms[0].length ||
                    rooms[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                int newDistance = rooms[cellInfo.row][cellInfo.col] + 1;;
                rooms[newRow][newCol] = newDistance;
                queue.add(new CellInfo(newRow, newCol));
            }
            
        }
    }
    
    class CellInfo {
        int row;
        int col;
        
        public CellInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
}
