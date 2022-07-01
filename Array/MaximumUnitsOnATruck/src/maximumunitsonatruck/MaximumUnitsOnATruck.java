/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumunitsonatruck;

import java.util.Arrays;

/**
 * LeetCode: 1710. Maximum Units on a Truck
 * Problem Link: https://leetcode.com/problems/maximum-units-on-a-truck/
 * @author souravpalit
 */
public class MaximumUnitsOnATruck {

    // Time Complexity: O(nlogn) Space Complexity: O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (int[] first, int[] second) -> 
                Integer.compare(second[1], first[1]));
        
        int numOfUnits = 0;
        
        for (int [] boxType : boxTypes) {
            if (truckSize - boxType[0] >= 0) {
                numOfUnits += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                numOfUnits += truckSize * boxType[1];
                break;
            }
        }
        
        return numOfUnits;
    }
    
}
