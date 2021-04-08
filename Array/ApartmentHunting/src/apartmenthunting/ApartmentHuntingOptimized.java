package apartmenthunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity O(B*R) where B is the block number and R is the requirements
 * number.Space Complexity: O(BR)
 * @author souravpalit
 */
public class ApartmentHuntingOptimized {
    
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
        int [][] minDistances = new int [reqs.length][];
        
        for (int i = 0; i < reqs.length; i++) {
            minDistances[i] = getMinDistances(blocks, reqs[i]);
        }
        
        int suitableBlock = 0;
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < blocks.size(); i++) {
            int distance = getMaxDistance(i, minDistances);
            if (distance < minDistance) {
                minDistance = distance;
                suitableBlock = i;
            }
        }
        
        return suitableBlock;
    }
    
    public static int getMaxDistance(int blockPos, int [][] minDistances) {
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < minDistances.length; i++) {
            max = Math.max(max, minDistances[i][blockPos]);
        }
        
        return max;
    }
    
    public static int[] getMinDistances(List<Map<String, Boolean>> blocks, String reqs) {
        int [] distances = new int [blocks.size()];
        int closestReqIndx = Integer.MAX_VALUE;
        
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(reqs)) {
                // If it is true. then add the index
                closestReqIndx = i;
            }
            distances[i] = Math.abs(i - closestReqIndx);
        }
        
        for (int i = blocks.size() -1; i >= 0; i--) {
            if (blocks.get(i).get(reqs)) {
                // If it is true. then add the index
                closestReqIndx = i;
            }
            distances[i] = Math.min(distances[i], Math.abs(i - closestReqIndx));
        }
        
        return distances;
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
