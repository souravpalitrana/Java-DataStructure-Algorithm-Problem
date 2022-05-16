/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpathinbinarymatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author souravpalit
 */
public class ShortestPathInBinaryMatrixSolution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        
        boolean [][] visited = new boolean[n][n];
        
        Queue<CellInfo> queue = new LinkedList<CellInfo>();
        queue.add(new CellInfo(0, 0, 1));
        
        int shortestPath = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            CellInfo cell = queue.remove();
            visited[cell.row][cell.col] = true;
            
            if (cell.row == n -1 && cell.col == n - 1) {
                shortestPath = Math.min(shortestPath, cell.cellCount);
            } else {
                List<CellInfo> neighbors = getNeighbors(grid, visited, cell);               
                
                for (CellInfo neighbor : neighbors) {
                    visited[neighbor.row][neighbor.col] = true;
                    queue.add(neighbor);
                }
            }
        }
                
        return (shortestPath == Integer.MAX_VALUE) ? -1 : shortestPath;
    }
    
    public List<CellInfo> getNeighbors(
            int [][] grid, 
            boolean[][] visited, 
            CellInfo currentCell
    ) {
        List<CellInfo> neighbors = new ArrayList<>();
        int n = grid.length;
        int row = currentCell.row;
        int col = currentCell.col;
        int count = currentCell.cellCount;
        
        // top
        if (row > 0 && shouldAddNeighbor(row - 1, col, visited, grid)) {
            neighbors.add(new CellInfo(row - 1, col, count + 1));
        }
        
        // top-right
        if (row > 0 && col < n - 1 && shouldAddNeighbor(row - 1, col + 1, visited, grid)) {
            neighbors.add(new CellInfo(row - 1, col + 1, count + 1));
        }
        
        // right
        if (col < n - 1 && shouldAddNeighbor(row, col + 1, visited, grid)) {
            neighbors.add(new CellInfo(row, col + 1, count + 1));
        }
        
        // bottom-right
        if (row < n - 1 && col < n - 1 && shouldAddNeighbor(row + 1, col + 1, visited, grid)) {
            neighbors.add(new CellInfo(row + 1, col + 1, count + 1));
        }
        
        // bottom
        if (row < n - 1 && shouldAddNeighbor(row + 1, col, visited, grid)) {
            neighbors.add(new CellInfo(row + 1, col, count + 1));
        }
        
        // bottom-left
        if (row < n - 1 && col > 0 && shouldAddNeighbor(row + 1, col - 1, visited, grid)) {
            neighbors.add(new CellInfo(row + 1, col - 1, count + 1));
        }
        
        // left
        if ( col > 0 && shouldAddNeighbor(row, col - 1, visited, grid)) {
            neighbors.add(new CellInfo(row, col - 1, count + 1));
        }
        
        // top-left
        if ( row > 0 && col > 0 && shouldAddNeighbor(row - 1, col - 1, visited, grid)) {
            neighbors.add(new CellInfo(row - 1, col - 1, count + 1));
        }
        
        return neighbors;
    }
    
    public boolean shouldAddNeighbor(int row, int col, boolean [][] visited, int[][] grid) {
        int lastRow = visited.length - 1;
        int lastCol = lastRow;
        
        if (row == lastRow && col == lastCol) {
            return true;
        } else if (visited[row][col] || grid[row][col] != 0) {
            return false;
        } else {
            return true;
        }
    }
    
    class CellInfo {
        int row;
        int col;
        int cellCount;
        
        public CellInfo(int row, int col, int cellCount) {
            this.row = row;
            this.col = col;
            this.cellCount = cellCount;
        }
    }
}
