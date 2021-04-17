/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedocument;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author souravpalit
 */
public class GenerateDocument {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String characters = "Palit Hello Sourav 12 asd";
        String document = "Hello Sourav Palit";
        
        System.out.print(canGenerateDocument(characters, document));
    }
    
    public static boolean canGenerateDocument(String characters, String document) {
        Map<Character, Integer> chractersFrequencyMap = getFrequencyMap(characters);
        Map<Character, Integer> documentFrequnceyMap = getFrequencyMap(document);
        
        for (Entry entry : documentFrequnceyMap.entrySet()) {
            if (!chractersFrequencyMap.containsKey(entry.getKey()) || 
                    chractersFrequencyMap.get(entry.getKey()) < documentFrequnceyMap.get(entry.getKey())) {
                return false;
            } 
        }
        
        return true;
    }
    
    public static Map<Character, Integer> getFrequencyMap(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            } else {
                frequencyMap.put(ch, 1);
            }
        }
        
        return frequencyMap;
    }
}
