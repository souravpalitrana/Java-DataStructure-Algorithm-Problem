/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package continuousmedian;

/**
 * Time Complexity O(logn) Space Complexity: O(n)
 * @author souravpalit
 */
public class ContinuousMedian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContinuousMedianHandler medianHandler = new ContinuousMedianHandler();
        medianHandler.insert(5);
        medianHandler.insert(10);
        medianHandler.insert(100);
        System.out.println(medianHandler.getMedian());
        medianHandler.insert(200);
        System.out.println(medianHandler.getMedian());
    }
    
}
