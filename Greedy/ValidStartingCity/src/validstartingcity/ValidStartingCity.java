/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validstartingcity;

/**
 * Time Complexity: O(n^2) Space Complexity: O(1)
 * @author souravpalit
 */
public class ValidStartingCity {

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
        for (int i = 0; i < distances.length; i++) {
            int fuelRemain = 0;
            boolean isValidCity = true;
            
            for (int j = i; j < i + distances.length; j++) {
                int cityIdx = j % distances.length;
                fuelRemain += fuel[cityIdx] * mpg;
                if (distances[cityIdx] > fuelRemain) {
                    isValidCity = false;
                    break;
                } else {
                    fuelRemain -= distances[cityIdx];
                }
            }
            
            if (isValidCity) {
                return i;
            }
        }
        
        return 0;
    }
    
}
