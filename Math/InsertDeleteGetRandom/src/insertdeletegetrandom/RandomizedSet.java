/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertdeletegetrandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author souravpalit
 */
public class RandomizedSet {

    private Random randomNumGenerator;
    private Map<Integer, Integer> map;
    private List<Integer> list;
    
    
    public RandomizedSet() {
        randomNumGenerator = new Random();
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            // First get the last value of the list because we delete from the 
            // last so that array indx doesn't change
            int lastValue = list.get(list.size() - 1);
            // Now get the idx of the value which we are going to delete
            int deletedIdx = map.get(val);
            // We can set the last value to the value we need to delete
            list.set(deletedIdx, lastValue);
            // Need to change in the map as well
            map.put(lastValue, deletedIdx);
            // Now last value has in two places. One at the last another is where
            // we need to deleted the target value. So we can delete the last one
            // as it will not change the other's value index position
            list.remove(list.size() - 1);
            // Need to remove from the map too.
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }
    
    public int getRandom() {
        return list.get(randomNumGenerator.nextInt(list.size()));
    }
    
}
