/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sunsetviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class SunsetViews {

    static String DIRECTION_EAST = "EAST";
    static String DIRECTION_WEST = "WEST";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = DIRECTION_WEST;
        ArrayList<Integer> sunsetViews = getSensetViews(buildings, direction);
        
        for (Integer view : sunsetViews) {
            System.out.println(view);
        }
    }
    
    public static ArrayList<Integer>  getSensetViews(int [] buildings, String direction) {
        ArrayList<Integer> buildingsIdx = new ArrayList<Integer>();
        int startIdx = buildings.length - 1;
        int step = -1; /// Basicall it will do -- task
        
        if (direction.equals(DIRECTION_WEST)) {
            startIdx = 0;
            step = 1; // It will do ++ task
        }
        
        int runningMaxHeight = 0;
        
        while (startIdx >= 0 && startIdx < buildings.length) {
            int buildingHeight = buildings[startIdx];
            
            if (buildingHeight > runningMaxHeight) {
                buildingsIdx.add(startIdx);
                runningMaxHeight = buildingHeight;
            }
            
            startIdx += step;
        }
       
        if (direction.equals(DIRECTION_EAST)) {
            Collections.reverse(buildingsIdx);
        }
        
        return buildingsIdx;
    }
}
