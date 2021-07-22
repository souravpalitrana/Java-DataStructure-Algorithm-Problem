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
 * Time & Space Complexity: (2n)! / (n! * (n + 1)!) 
 * @author souravpalit
 */
public class GenerateDivTagsOptimized {

    static String STARTING_TAG = "<div>";
    static String ENDING_TAG = "</div>";
    
    public static void main(String[] args) {
        int numberOfTags = 3;
        ArrayList<String> tags = generateDivTags(numberOfTags);
        
        for (String tag : tags) {
            System.out.println(tag);
        }
    }
    
    public static ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> result = new ArrayList<String>();
        String [] str = new String[numberOfTags * 2];
        generateDivTags(result, numberOfTags, numberOfTags, str, 0);
        return result;
    }
    
    public static void generateDivTags(ArrayList<String> result, 
            int openingTagsCount, int closingTagsCount, String [] prefix, int index) {
        if (openingTagsCount < 0 || openingTagsCount > closingTagsCount) {
            return;
        }
        
        if (openingTagsCount == 0 && closingTagsCount == 0) {
            result.add(String.join("", prefix));
        } else {
            prefix[index] = STARTING_TAG;
            generateDivTags(result, openingTagsCount - 1, closingTagsCount, prefix, index + 1);
            prefix[index] = ENDING_TAG;
            generateDivTags(result, openingTagsCount, closingTagsCount - 1, prefix, index + 1);
        }
    }
}
