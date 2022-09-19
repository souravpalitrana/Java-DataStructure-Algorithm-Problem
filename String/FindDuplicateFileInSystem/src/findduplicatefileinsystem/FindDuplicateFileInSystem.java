/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findduplicatefileinsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode: 609. Find Duplicate File in System
 * Problem Link: https://leetcode.com/problems/find-duplicate-file-in-system/
 * Detailed Explanation: https://leetcode.com/problems/find-duplicate-file-in-system/discuss/2598077/Java-HashMap-Solution-with-the-step-by-step-Explanation
 * @author souravpalit
 */
public class FindDuplicateFileInSystem {

    // Time Complexity: O(ns) where n is the number of n path and s is the length of each path.
    // Space Complexity: O(ns) where n is the number of n path and s is the length of each path.
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,  List<String>> fileSystem = new HashMap<>();
        for (String path : paths) {
            String [] parts = path.split(" ");
            String directoryName = null;
            for (String part : parts) {
                if (directoryName == null) {
                    directoryName = part;
                } else {
                    int firstBracketIdx = part.indexOf("(");
                    StringBuilder fileNameBuilder = new StringBuilder();
                    fileNameBuilder.append(directoryName);
                    fileNameBuilder.append("/");
                    fileNameBuilder.append(part.substring(0, firstBracketIdx));
                    String content = part.substring(firstBracketIdx + 1, part.length() - 1);
                    fileSystem.putIfAbsent(content, new ArrayList<String>());
                    fileSystem.get(content).add(fileNameBuilder.toString());
                }
            }
        }
        
        List<List<String>> duplicates = new ArrayList<>();
        for (List<String> value : fileSystem.values()) {
            if (value.size() > 1) {
                duplicates.add(value);
            }
        } 
        return duplicates;
    }
    
}
