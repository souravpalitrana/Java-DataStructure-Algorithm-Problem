/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedivtags;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This problem is similar to Parentheses problem
 * @author souravpalit
 */
public class GenerateDivTags {

    static char STARTING_BRACKET = '(';
    static char ENDING_BRACKET = ')';
    static String STARTING_TAG = "<div>";
    static String ENDING_TAG = "</div>";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numberOfTags = 3;
        ArrayList<String> tags = generateDivTags(numberOfTags);
        
        for (String tag : tags) {
            System.out.println(tag);
        }
    }
    
    public static ArrayList<String> generateDivTags(int numberOfTags) {
        Set<String> tags = generateParentheses(numberOfTags);
        ArrayList<String> newTags = new ArrayList<String>();
        for (String tag : tags) {
            newTags.add(format(tag));
        }
        return newTags;
    }
    
    public static Set<String> generateParentheses(int numberOfTags) {
        Set<String> results = new HashSet<String>();
        
        if (numberOfTags == 0) {
            results.add("");
        } else {
            Set<String> tags = generateParentheses(numberOfTags - 1);
            
            for (String tag : tags) {
                for (int i = 0; i < tag.length(); i++) {
                    if (tag.charAt(i) == STARTING_BRACKET) {
                        results.add(insertAtPosition(tag, i)); 
                    }
                }
                results.add(tag + STARTING_BRACKET + ENDING_BRACKET);
            }
        }
        
        return results;
    }
    
    public static String insertAtPosition(String tag, int position) {
        String prefix = tag.substring(0, position + 1);
        String suffix = tag.substring(position + 1);
        return prefix + STARTING_BRACKET + ENDING_BRACKET + suffix;
    }
    
    public static String format(String tag) {
        String newString = "";
        
        for (int i = 0; i < tag.length(); i++) {
            if (tag.charAt(i) == STARTING_BRACKET) {
                newString += STARTING_TAG;
            } else {
                newString += ENDING_TAG;
            }
        }
        return newString;
    }
    
}
