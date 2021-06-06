/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classphoto;

import java.util.Arrays;
import java.util.Collections;

/**
 * Time Complexity: O(nlog(n)) and Space Complexity: O(1)
 * @author souravpalit
 */
public class ClassPhoto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] redShirtHeights = {5, 8, 1, 3, 4};
        int [] blueShirtHeights = {6, 9, 2, 4, 5};
        
        System.out.println("Can take class photo: " + canTakeClassPhoto(redShirtHeights, blueShirtHeights));
    }
    
    public static boolean canTakeClassPhoto(int [] redShirtHeights, int [] blueShirtHeights) {
        Arrays.sort(redShirtHeights);
        Arrays.sort(blueShirtHeights);
        
        boolean isRedShirtTaller = redShirtHeights[redShirtHeights.length - 1] > blueShirtHeights[blueShirtHeights.length - 1];
        
        for (int i = 0; i < redShirtHeights.length; i++) {
            if (isRedShirtTaller) {
                // red must be greater as we need to set them behind
                if (redShirtHeights[i] <= blueShirtHeights[i]) {
                    return false;
                }
            } else {
                // Blue must be greater as we need to set them behind
                if (blueShirtHeights[i] <= redShirtHeights[i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
