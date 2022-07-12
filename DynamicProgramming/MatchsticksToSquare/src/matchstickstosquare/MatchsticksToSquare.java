/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchstickstosquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class MatchsticksToSquare {
    
    public static void main(String args[]) {
        int [] sticks = {5,5,5,5,4,4,4,4,3,3,3,3};
        //System.out.println(makesquare(sticks));
    }

    // TC: O(4^n) O(n)
    int [] sides;
    int eachSideLength;
    
    public boolean makesquare(int [] matchSticks) {
        sides = new int [4];
        int totalLength = 0;
        List<Integer> sticks = new ArrayList<>();
        for (int stickLength : matchSticks) {
            totalLength += stickLength;
            sticks.add(stickLength);
        }
        
        eachSideLength = totalLength / 4;
        if (eachSideLength * 4 != totalLength) {
            return false;
        }
        
        Collections.sort(sticks, Collections.reverseOrder());
        return explore(sticks, 0);
    }
    
    public boolean explore(List<Integer> matchSticks, int stickIdx) {
        if (stickIdx == matchSticks.size()) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        
        int stickLength = matchSticks.get(stickIdx);
        
        for (int i = 0; i < 4; i++) {
            int currentLength = sides[i] + stickLength;
            if (sides[i] + stickLength <= eachSideLength) {
                sides[i] += stickLength;
                if (explore(matchSticks, stickIdx + 1)) {
                    return true;
                }
                sides[i] -= stickLength;
            }
        }
        
        return false;
    }
    
}
