/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackofboxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class StackOfBoxes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<Box>();
        boxes.add(new Box(4, 5, 5));
        boxes.add(new Box(4, 6, 6));
        boxes.add(new Box(5, 5, 7));
        boxes.add(new Box(7, 7, 8));
        boxes.add(new Box(4, 4, 6));
        
        System.out.println(createStack(boxes));
    }
    
    public static int createStack(ArrayList<Box> boxs) {
        Collections.sort(boxs, new BoxComparator());
        int maxHeight = 0;
        
        for ( int i = 0; i < boxs.size(); i++) {
            int height = createStack(boxs, i);
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxHeight;
    }
    
    public static int createStack(ArrayList<Box> boxs, int index) {
        Box bottom = boxs.get(index);
        int maxHeight = 0;
        
        for (int i = index + 1; i < boxs.size(); i++) {
            if (boxs.get(i).canPlaceAbove(bottom)) {
                int height = createStack(boxs, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        
        maxHeight += bottom.getHeight();
        return maxHeight;
    }
    
}
