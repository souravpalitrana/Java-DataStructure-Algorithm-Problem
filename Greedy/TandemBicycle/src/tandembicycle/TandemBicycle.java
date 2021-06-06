/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandembicycle;

import java.util.Arrays;

/**
 * Time Complexity: O(nlong(n)) and Space Complexity: O(1)
 * @author souravpalit
 */
public class TandemBicycle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] redShirtSpeeds = {5, 5, 3, 9, 2};
        int [] blueShirtSpeeds = {3, 6, 7, 2, 1};
        boolean fastest = false;
        System.out.println(tandemBicyle(redShirtSpeeds, blueShirtSpeeds, fastest));
    }
    
    public static int tandemBicyle(int [] redShirtSpeeds, int [] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        
        int redIdx = 0;
        int blueIdx = fastest ? blueShirtSpeeds.length - 1 : 0; 
        int blueStep = fastest ? -1 : 1; 
        int totalSpeed = 0;
        
        while (redIdx < redShirtSpeeds.length && blueIdx >= 0 && blueIdx < redShirtSpeeds.length) {
            totalSpeed += Math.max(redShirtSpeeds[redIdx], blueShirtSpeeds[blueIdx]);
            redIdx++;
            blueIdx += blueStep;
        }
        
        return totalSpeed;
    } 
    
}
