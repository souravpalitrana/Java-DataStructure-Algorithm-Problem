/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validstartingcity;

/**
 * Time Complexity: O(n) Space Complexity: O(1)
 * @author souravpalit
 */
public class ValidStartingCityOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] distances = {5, 25, 15, 10, 15};
        int [] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;
        System.out.println("Valid starting city is : " + findValidStartingCity(distances, fuel, mpg));
    }
    
    public static int findValidStartingCity(int [] distances, int [] fuel, int mpg) {
        int milesRemaining = 0;
        int startingCityIdx = 0;
        int milesRemainingAtStartingCity = 0;
        
        for (int i = 1; i < distances.length; i++) {
            int fuelFromPreviousCity = fuel[i - 1] * mpg;
            int distanceFromPreviousCity = distances[i - 1];
            milesRemaining += fuelFromPreviousCity - distanceFromPreviousCity;
            
            if (milesRemaining < milesRemainingAtStartingCity) {
                milesRemainingAtStartingCity = milesRemaining;
                startingCityIdx = i;
            }
        }
        
        return startingCityIdx;
    }
    
}
