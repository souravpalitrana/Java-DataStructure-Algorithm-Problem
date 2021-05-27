/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minmaxstackconstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class MinMaxStack {
    
    List<Integer> stack = new ArrayList<Integer>();
    List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
    
    // T: O(1) S: O(1)
    public int peek() {
      return stack.get(stack.size() - 1);
    }

    // T: O(1) S: O(1)
    public int pop() {
      int value = stack.get(stack.size() - 1);
      stack.remove(stack.size() - 1);
      minMaxStack.remove(minMaxStack.size() - 1);
      return value;
    }

    // T: O(1) S: O(1)
    public void push(Integer number) {
      Map<String, Integer> maxMin = new HashMap<String, Integer>();
      
      if (stack.size() == 0) {
          maxMin.put("max", number);
          maxMin.put("min", number);
      } else {
          Map<String, Integer> lastMaxMin = minMaxStack.get(minMaxStack.size() - 1);
          maxMin.put("max", Math.max(number, lastMaxMin.get("max")));
          maxMin.put("min", Math.min(number, lastMaxMin.get("min")));
      }
      
      minMaxStack.add(maxMin);
      stack.add(number);
    }

    // T: O(1) S: O(1)
    public int getMin() {
      return minMaxStack.get(minMaxStack.size() - 1).get("min");
    }

    // T: O(1) S: O(1)
    public int getMax() {
      return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }
    
}
