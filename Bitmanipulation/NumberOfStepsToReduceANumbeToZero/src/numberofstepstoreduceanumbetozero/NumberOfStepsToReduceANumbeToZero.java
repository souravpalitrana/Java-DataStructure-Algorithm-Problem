/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberofstepstoreduceanumbetozero;

/**
 *
 * @author souravpalit
 */
public class NumberOfStepsToReduceANumbeToZero {

    public int numberOfSteps(int num) {
        int step = 0;
        
        while (num  != 0) {
            if (num % 2 == 1) {
                num--;
            } else {
                num = num / 2;
            }
             step++;
        }
        
        return step;
    }
    
}
