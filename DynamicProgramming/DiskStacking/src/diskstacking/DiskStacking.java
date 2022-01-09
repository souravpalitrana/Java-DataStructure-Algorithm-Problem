/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diskstacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Time Complexity: O(n^2) Space Complexity: O(n)
 * @author souravpalit
 */
public class DiskStacking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer []> disks = new ArrayList<Integer []>();
        /*disks.add(new Integer[] {2, 1, 2});
        disks.add(new Integer[] {3, 2, 3});
        disks.add(new Integer[] {2, 2, 8});
        disks.add(new Integer[] {2, 3, 4});
        disks.add(new Integer[] {2, 2, 1});
        disks.add(new Integer[] {4, 4, 5});*/
        
        disks.add(new Integer[] {2, 1, 2});
        disks.add(new Integer[] {3, 2, 3});
        disks.add(new Integer[] {2, 2, 8});
        
        List<Integer []> result = diskStacking(disks);
        
        for (Integer [] items : result) {
            System.out.print("[");
            for (Integer value : items) {
                System.out.print(value + " ");
            }
            System.out.print("]");
        }
    }
    
    public static List<Integer []> diskStacking(List<Integer []> disks) {
        Collections.sort(disks, new Comparator<Integer []>() {
            @Override
            public int compare(Integer[] first, Integer[] second) {
                return first[2] - second[2] ;
            }
            
        });
        
        int [] heights = new int [disks.size()];
        int [] sequences = new int [disks.size()];
        
        Arrays.fill(sequences, -1);
        
        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
        }
        
        int maxHeight = Integer.MIN_VALUE;
        int maxBottomIdx = 0;
        for (int i = 1; i < disks.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (canStackDisk(disks.get(i), disks.get(j))) {
                    int currentHeight = heights[j] + disks.get(i)[2];
                    if (currentHeight > heights[i]) {
                        heights[i] = currentHeight;
                        sequences[i] = j;
                    }
                }
            }
            
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxBottomIdx = i;
            }
        }
        
        return buildSequence(sequences, disks, maxBottomIdx);
    }
    
    public static boolean canStackDisk(Integer [] bottom, Integer [] top) {
        return (bottom[0] > top[0] && bottom[1] > top[1] && bottom[2] > top[2]);
    }
    
    public static List<Integer []> buildSequence(int [] sequences, List<Integer []> disks, int maxBottomIdx) {
        List<Integer []> result = new ArrayList<Integer []>();
        
        int idx = maxBottomIdx;
        while (idx >= 0) {
            result.add(0, disks.get(idx));
            idx = sequences[idx];
        }
        
        
        return result;
    }
}
