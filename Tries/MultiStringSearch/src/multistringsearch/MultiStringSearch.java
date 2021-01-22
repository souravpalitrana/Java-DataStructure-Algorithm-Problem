/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multistringsearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class MultiStringSearch {
    
    public static void main(String args []) {
        String bigString = "this is a big string";
        String [] smallString = {"this", "yo", "is", "a", "bigger", "string", "appa"};
        
        List<Boolean> result = multiStringSearch(bigString, smallString);
        
        for (Boolean value : result) {
            System.out.print(value + "   ");
        }
    }
    
    public static List<Boolean> multiStringSearch(String bigString, String [] smallStrings) {
        List<Boolean> result = new ArrayList<Boolean>();
        
        for (String smallString : smallStrings) {
            result.add(isPresent(bigString, smallString));
        }
        
        return result;
    }
    
    public static boolean isPresent(String bigString, String smallString) {
        for (int i = 0; i < bigString.length(); i++) {
            if (i + smallString.length() > bigString.length()) {
                break;
            }
            
            if (isPresent(bigString, smallString, i)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean isPresent(String bigString, String smallString, int position) {
        int startPosInBig = position;
        int endPosInBig = position + smallString.length() -1;
        int startPosInSmall = 0;
        int endPosInSmall = smallString.length() - 1;
        
        while (startPosInBig <= endPosInBig) {
            if (bigString.charAt(startPosInBig) != smallString.charAt(startPosInSmall) ||
                    bigString.charAt(endPosInBig) != smallString.charAt(endPosInSmall)) {
                return false;
            }
            
            startPosInBig++;
            startPosInSmall++;
            endPosInBig--;
            endPosInSmall--;
        }
        
        return true;
    }
}
