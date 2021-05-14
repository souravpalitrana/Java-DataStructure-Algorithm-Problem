/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patternmatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n^2 + m) time where n^2 is for generating each string and m is for generating pattern
 * Space O(n + m) where n is for generating string each time and m is for new pattern
 * @author souravpalit
 */
public class PatternMatcher {

    public static char X = 'x';
    public static char Y = 'y';
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String pattern = "xxyxxy";
        //String text = "gogopowerrangergogopowerranger";
        String pattern = "yyyy";
        String text = "testtesttesttest";
        String [] xYValue = patternMatcher(text, pattern);
        
        System.out.println("X : " + xYValue[0] + "  Y: " + xYValue[1]);
    }
    
    public static String [] patternMatcher(String text, String pattern) {
        String [] xYValues = new String[2];
        String newPattern = switchPatternIfRequired(pattern);
        boolean isSwitched = !pattern.equals(newPattern);
        Map<Character, Integer> characterCountMap = new HashMap<Character, Integer>();
        countCharacters(characterCountMap, newPattern);
        if (characterCountMap.get(Y) != 0) {
            int firstYPosition = getFirstYPosition(newPattern);
            for (int lenOfX = 1; lenOfX < text.length(); lenOfX++) {

                int totalCharactersForX = lenOfX * characterCountMap.get(X);
                int totalCharactersForY = text.length() - totalCharactersForX;
                double lenOfY = (double) totalCharactersForY / (double) characterCountMap.get(Y);
                if (lenOfY <= 0 || lenOfY % 1 != 0) {
                    continue;
                }

                int yIdx = firstYPosition * lenOfX;  // firstYPosition reperesents number of X before Y as well.
                // for example y position 2 meanse 2 x before y so if we multiply lenOfX with yPosition then
                // we will get the exact start position of Y in the given text
                String x = text.substring(0, lenOfX);
                String y = text.substring(yIdx, yIdx + (int) lenOfY);

                String generatedString = generateStringBaseOnPattern(x, y, newPattern);
                if (text.equals(generatedString)) {
                    xYValues[0] = isSwitched ? y : x;
                    xYValues[1] = isSwitched ? x : y;
                    return xYValues;
                }
            }
        } else {
            double lenOfX = (double) text.length() / (double) characterCountMap.get(X);
            if (lenOfX % 1 == 0) {
                String x = text.substring(0, (int) lenOfX);
                String generatedString = generateStringBaseOnPattern(x, "", newPattern);
                if (text.equals(generatedString)) {
                    xYValues[0] = isSwitched ? "" : x;
                    xYValues[1] = isSwitched ? x : "";
                    return xYValues;
                }
            }
        }
         
        return new String[] {};
    }
    
    public static String switchPatternIfRequired(String pattern) {
        if (pattern.charAt(0) == X) {
            return pattern;
        }
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (ch == X) {
                builder.append(Y);
            } else {
               builder.append(X);
            }
        }
        
        return builder.toString();
    }
    
    public static void countCharacters(Map<Character, Integer> counter, String pattern) {
        int xCount = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == X) {
                xCount++;
            }
        }
        
        counter.put(X, xCount);
        counter.put(Y, pattern.length() - xCount);
    }
    
    public static int getFirstYPosition(String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == Y) {
                return i;
            }
        }
        
        return 0;
    }
    
    public static String generateStringBaseOnPattern(String xValue, String yValue, String pattern) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            builder.append((pattern.charAt(i) == X) ? xValue : yValue);
        }
        return builder.toString();
    }
}
