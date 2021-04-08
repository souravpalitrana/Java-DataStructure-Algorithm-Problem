package apartmenthunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity O(B^2*R) where B is the block number and R is the requirements
 * number.Space Complexity: O(1)
 * @author souravpalit
 */
public class ApartmentHunting {
    
    public static String gym = "gym";
    public static String school = "school";
    public static String store = "store";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>();
        String [] requirements = {gym, school, store};
        blocks.add(getBlock(false, true, false));
        blocks.add(getBlock(true, false, false));
        blocks.add(getBlock(true, true, false));
        blocks.add(getBlock(false, true, false));
        blocks.add(getBlock(false, true, true));
        System.out.println("Suitable apartment is : " + getSuitableApartment(blocks, requirements));
        
    }
    
    public static int getSuitableApartment(List<Map<String, Boolean>> blocks, String[] reqs) {
        int distance = Integer.MAX_VALUE;
        int blockPos = 0;
        for (int i = 0; i < blocks.size(); i++) {
            Map<String, Boolean> block = blocks.get(i);
            
            int cost = Integer.MIN_VALUE;
            for (int j = 0; j < reqs.length; j++) {
                if (!block.get(reqs[j])) {
                    int costUpWord = findCostUpWord(i, blocks, reqs[j]);
                    int costDownWord = findCostDownWord(i, blocks, reqs[j]);
                    int maxCost = Math.min(costUpWord, costDownWord);
                    cost = Math.max(maxCost, cost);
                }
            }
            
            if (cost < distance) {
                distance = cost;
                blockPos = i;
            }
        }
        
        return blockPos;
    }
    
    public static int findCostUpWord(int currentBlockPos, 
            List<Map<String, Boolean>> blocks, String req) {
        if (currentBlockPos == 0) {
            return Integer.MAX_VALUE; // not found
        } else {
            for (int i = currentBlockPos - 1; i>= 0; i--) {
                Map<String, Boolean> block = blocks.get(i);
                
                if (block.get(req)) {
                    return currentBlockPos - i;
                }
            }
            
            return Integer.MAX_VALUE;
        }
    }
    
    public static int findCostDownWord(int currentBlockPos, 
            List<Map<String, Boolean>> blocks, String req) {
        if (currentBlockPos == blocks.size() - 1) {
            return Integer.MAX_VALUE; // not found
        } else {
            for (int i = currentBlockPos + 1; i< blocks.size(); i++) {
                Map<String, Boolean> block = blocks.get(i);
                
                if (block.get(req)) {
                    return i - currentBlockPos;
                }
            }
            
            return Integer.MAX_VALUE;
        }
    }
    
    public static Map<String, Boolean> getBlock(boolean first, 
            boolean second, boolean third) {
        Map<String, Boolean> block = new HashMap<String, Boolean>();
        block.put(gym, first);
        block.put(school, second);
        block.put(store, third);
        
        return block;
    }
    
}
