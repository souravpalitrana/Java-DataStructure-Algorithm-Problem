/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumspeedtoarriveontime;

/**
 *
 * @author souravpalit
 */
public class MinimumSpeedToArriveOnTime {

    // TC: O(nlogn) SC: O(1)
    public int minSpeedOnTime(int[] dist, double hour) {
        int minSpeed = 1; // As minimum speedd is 1 as given
        int maxSpeed = 10000000; // As maximum speed can be 10^5 
        int result = -1;
        
        while (minSpeed <= maxSpeed) {
            int speed = (minSpeed + (maxSpeed - minSpeed) / 2);
            double hourRequiredToReach = calculateHourToReach(dist, speed);
            
            if (hourRequiredToReach > hour) {
                minSpeed = speed + 1;
            } else {
                result = speed;
                maxSpeed = speed - 1;
            }
        }
        
        return result;
    }
    
    public double calculateHourToReach(int[] dist, int speed) {
        double hourRequired = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            hourRequired += Math.ceil(((double) dist[i] /speed)); 
        }
        // At last station you don't need to wait anymore so avoid ceiling
        hourRequired += ((double) dist[dist.length - 1] /speed); 
        return hourRequired;
    }
    
}
