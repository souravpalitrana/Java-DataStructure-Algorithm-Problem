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
public class StackOfBoxesOptimized {

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
    
    public static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;
        int [] memory = new int [boxes.size()];
        
        for ( int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, memory);
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxHeight;
    }
    
    public static int createStack(ArrayList<Box> boxes, int index, int [] memory) {
        if (index < boxes.size() && memory[index] > 0) {
            return memory[index];
        }
        
        Box bottom = boxes.get(index);
        int maxHeight = 0;
        
        for (int i = index + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canPlaceAbove(bottom)) {
                int height = createStack(boxes, i, memory);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        
        maxHeight += bottom.getHeight();
        memory[index] = maxHeight;
        return maxHeight;
    }
    
}
