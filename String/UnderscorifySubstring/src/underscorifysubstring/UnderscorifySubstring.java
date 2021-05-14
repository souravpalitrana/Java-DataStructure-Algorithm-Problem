/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package underscorifysubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Average Case O(n+m) and Space: O(n) where n is the string length and m is 
 * the substring length.
 * Worst Case O(n(n+m)) and Space: O(n)
 * @author souravpalit
 */
public class UnderscorifySubstring {

    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";
        String substring = "test";
        System.out.println(underscorifySubstring(str, substring));
        
    }
    
    public static String underscorifySubstring(String str, String substring) {
        List<Integer []> locations = getLocations(str, substring);
        List<Integer []> flattenedLocations = flattenLocations(locations);
        return addUnderscoresToLocations(str, flattenedLocations);
    }
    
    public static List<Integer []> getLocations(String str, String substring) {
        List<Integer []> locations = new ArrayList<Integer []>();
        
        int startIdx = 0;
        
        while (startIdx < str.length()) {
            int location = str.indexOf(substring, startIdx);
            
            if (location != -1) {
                locations.add(new Integer[] {location, location + substring.length()});
                startIdx = location + 1;
            } else {
                break;
            }
        }
        
        return locations;
    }
    
    public static List<Integer []> flattenLocations(List<Integer []> locations) {
        if (locations.size() < 2) {
            return locations;
        }
        
        List<Integer []> flattenedLocations = new ArrayList<Integer []>();
        flattenedLocations.add(locations.get(0));
        
        for (int i = 1; i < locations.size(); i++) {
            Integer[] current = locations.get(i);
            Integer [] previous = flattenedLocations.get(flattenedLocations.size() - 1); // Getting the last value
            
            if (current[0] <= previous[1]) {
                previous[1] = current[1];
            } else {
                flattenedLocations.add(current);
            }
        }
        
        return flattenedLocations;
    }
    
    public static String addUnderscoresToLocations(String str, List<Integer []> locations) {
        if (locations.size() < 1) {
            return str;
        }
        
        int locationIdx = 0;
        List<String> letters = new ArrayList<String>();
        
        for (int i = 0; i < str.length(); i++) {
            String letter = str.charAt(i) + "";
            int startIdx = locations.get(locationIdx)[0];
            int endIdx = locations.get(locationIdx)[1];
            
            if (i == startIdx) {
                letters.add("_");
            }
            
            letters.add(letter);
            
            if (i == endIdx - 1) {
                letters.add("_");
                locationIdx++;
                if (locationIdx >= locations.size()) {
                    locationIdx = locations.size() - 1;
                }
            }
        }
        
        return String.join("", letters);
    }
}
