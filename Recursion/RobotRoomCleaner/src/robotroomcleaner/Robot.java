/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotroomcleaner;

/**
 *
 * @author souravpalit
 */
public interface Robot {
    
    public boolean move();
    public void turnLeft();
    public void turnRight();
    public void clean();
}
