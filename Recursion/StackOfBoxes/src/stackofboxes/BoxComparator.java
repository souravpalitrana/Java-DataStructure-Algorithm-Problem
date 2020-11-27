/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackofboxes;

import java.util.Comparator;

/**
 *
 * @author souravpalit
 */
public class BoxComparator implements Comparator<Box> {

    @Override
    public int compare(Box o1, Box o2) {
        return o2.getHeight() - o1.getHeight();
    }
    
}
