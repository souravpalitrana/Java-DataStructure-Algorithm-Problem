/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutationsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class PermutationsIISolution {
    
    // Same code as permutation with seen tracking
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<String> seen = new HashSet<String>();
        return permute(nums, seen);
    }
    
    public List<List<Integer>> permute(int[] nums, Set<String> seen) {
        List<List<Integer>> permutation = new ArrayList<>();
        
        Integer numbers [] = new Integer[nums.length];
        for (int i = 0;  i< nums.length; i++) {
            numbers[i] = nums[i];
        }
        permute(numbers, 0, permutation, seen);
        return permutation;
    }
    
    public void permute(Integer [] nums, int pos, List<List<Integer>> permutation, Set<String> seen) {
        if (pos == nums.length) {
           List<Integer> list = new ArrayList<>();
            for (Integer value : nums) {
                list.add(value);;
            }
            String key = generateKey(list);
            if (seen.contains(key)) {
                return;
            }
            permutation.add(list);
            seen.add(key);
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            permute(nums, pos + 1, permutation, seen);
            swap(nums, pos, i);
        }
    }
    
    public void swap(Integer [] nums, int i, int j) {
        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public String generateKey(List<Integer> nums) {
        String key = "";
        for (int i = 0; i < nums.size(); i++) {
            key = key + nums.get(i);
            if (i < nums.size() - 1) {
                key = key + " ";
            }
        }
        return key;
    }
}
