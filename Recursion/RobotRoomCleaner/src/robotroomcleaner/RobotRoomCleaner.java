/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotroomcleaner;

import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

/**
 * Leetcode: 489. Robot Room Cleaner
 * Problem Link: https://leetcode.com/problems/robot-room-cleaner/
 * @author souravpalit
 */
public class RobotRoomCleaner {
   
    private int directions [] = {-1, 0, 1, 0, -1}; // up-right-down-left
    private Set<Pair> visited = new HashSet<>();
    
    // TC: O(M) where M is the number of cell without obstacle or we can say
    // number of empty Cell
    // SC: O(M) where M is the number of cell without obstacle or we can say
    // number of empty Cell. This is required to track which room we cleaned
    public void cleanRoom(Robot robot) {
        // 0 - up, 1 - right, 2 - down, 3 - left
        cleanRoom(robot, 0, 0, 0);
    }
     
    private void cleanRoom(Robot robot, int x, int y, int direction) {
        visited.add(new Pair(x, y));
        robot.clean();
        
        // Exploring all four directions
        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4; // circular direction
            int newX = x + directions[newDirection];
            int newY = y + directions[newDirection + 1];
            
            if (!visited.contains(new Pair(newX, newY)) && robot.move()) {
                // Robot already completed the move. So explore from that position
                cleanRoom(robot, newX, newY, newDirection);
                // Here we already explored all four position. No way to go 
                // so go back
                goBack(robot);
            }
            
            // Move Right always when could not go further
            robot.turnRight();
        }
    }
    
    
    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
           
}
