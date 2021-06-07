/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(nlog(n)) and Space Complexity: O(n)
 * @author souravpalit
 */
public class TaskAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k = 3;
        int [] tasks = {1,3,5,3,1,4};
        ArrayList<ArrayList<Integer>> assignedList = taskAssignment(k, tasks);
        
        for (ArrayList<Integer> task : assignedList) {
            System.out.println("[" + task.get(0) + "," + task.get(1) + "]");
        }
    }
    
    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, int [] tasks) {
        Map<Integer, ArrayList<Integer>> indexMap = mapTasksIndex(tasks);
        ArrayList<ArrayList<Integer>> taskList = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(tasks);
        int i = 0;
        int j = tasks.length - 1;
        while (i < j) {
            ArrayList<Integer> task = new ArrayList<Integer>();
            int firstTask = tasks[i];
            int secondTask = tasks[j];
            
            ArrayList<Integer> firstIndexList = indexMap.get(firstTask);
            ArrayList<Integer> secondIndexList = indexMap.get(secondTask);
            
            // It will remove the last value and return the value also
            int firstIndex = firstIndexList.remove(firstIndexList.size() - 1); 
            int secondIndex = secondIndexList.remove(secondIndexList.size() - 1);     
            
            task.add(firstIndex);
            task.add(secondIndex);
            taskList.add(task);
            
            i++;
            j--;
        }
        
        return taskList;
    }
    
    private static Map<Integer, ArrayList<Integer>> mapTasksIndex(int [] tasks) {
        Map<Integer, ArrayList<Integer>> indexMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < tasks.length; i++) {
            int value = tasks[i];
            if (indexMap.containsKey(value)) {
                indexMap.get(value).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                indexMap.put(value, list);
            }
        }
        return indexMap;
    }
}
