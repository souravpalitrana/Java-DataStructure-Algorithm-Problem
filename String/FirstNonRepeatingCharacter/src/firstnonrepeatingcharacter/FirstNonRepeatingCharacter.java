/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstnonrepeatingcharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity O(n). Space Complexity O(1) why? because we have only lower
 * case letter which is exactly 26. So in the hash map we may have at most 26 letter
 * which will not change with input size. Thats why it is constant space.
 * @author souravpalit
 */
public class FirstNonRepeatingCharacter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "abcdcaf";
        System.out.println(getFirstNonRepeatingCharacter(str));
    }
    
    public static int getFirstNonRepeatingCharacter(String str) {
        Map<Character, Integer> frequencyTable = getFrequencyTable(str);
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (frequencyTable.get(ch) == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static Map<Character, Integer> getFrequencyTable(String str) {
        Map<Character, Integer> frequencyTable = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            frequencyTable.put(key, frequencyTable.getOrDefault(key, 0) + 1);
        }
        
        return frequencyTable;
    }
    
}
