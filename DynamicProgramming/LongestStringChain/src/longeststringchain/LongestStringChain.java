/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longeststringchain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: O(nm^2)
 * Space Complexity: O(nm)
 * @author souravpalit
 */
public class LongestStringChain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String [] strings = {"abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"};
        List<String> longestStringChains = longestStringChain(Arrays.asList(strings));
        
        System.out.print(" [ ");
        
        for (String string : longestStringChains) {
            System.out.print(string + "  ");
        }
        
        System.out.print(" ] ");
    }
    
    public static List<String> longestStringChain(List<String> strings) {
        Map<String, StringChain> stringChains = new HashMap<String, StringChain>();
        
        for (String string : strings) {
            StringChain chain = new StringChain("", 1);
            stringChains.put(string, chain);
        }
        
        List<String> sortedStrings = new ArrayList<String>(strings);
        sortedStrings.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }           
        });
        
        
        for (String string : sortedStrings) {
            findLongestStringChain(string, stringChains);
        }
        
        return buildSequence(sortedStrings, stringChains);
    }
    
    public static void findLongestStringChain(String currentString, Map<String, StringChain> stringChains) {
        
        for (int i = 0; i < currentString.length(); i++) {
            String smallerString = getSmallerString(i, currentString);
            if (stringChains.containsKey(smallerString)) {
                int smallerStringLength = stringChains.get(smallerString).length;
                int currentStringLength = stringChains.get(currentString).length;
                
                if (smallerStringLength + 1 > currentStringLength) {
                    stringChains.get(currentString).length = smallerStringLength + 1;
                    stringChains.get(currentString).nextString = smallerString;
                }
            }
        }
    }
    
    public static String getSmallerString(int position, String string) {
        return string.substring(0, position) + string.substring(position + 1);
    }
    
    public static List<String> buildSequence(List<String> strings, Map<String, StringChain> stringChain) {
        List<String> longestChain = new ArrayList<String>();
        
        int maxLength = Integer.MIN_VALUE;
        String chainStartingString = "";
        for (String string : strings) {
            StringChain chain = stringChain.get(string);
            if (chain.length > maxLength) {
                maxLength = chain.length;
                chainStartingString = string;
            }
        }
        
        String currentString = chainStartingString;
        
        while (!currentString.isEmpty()) {
            longestChain.add(currentString);
            currentString = stringChain.get(currentString).nextString;
        }
        
        return (longestChain.size() == 1) ? new ArrayList() : longestChain;
    }
    
}
