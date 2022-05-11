/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countsortedvowelstrings;

/**
 *
 * @author souravpalit
 */
public class CountSortedVowelStringsSolution {
    
    public int countVowelStrings(int n) {
        return countVowelStringUtil(n, 1, "");
    }

    int countVowelStringUtil(int n, int vowels, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return 1;
        }
            
        int result = 0;
        for (int i = vowels; i <= 5; i++) {
            prefix = prefix + getVowel(i);
            result += countVowelStringUtil(n - 1, i, prefix);
            StringBuilder builder = new StringBuilder(prefix);
            builder.deleteCharAt(prefix.length() - 1);
            prefix = builder.toString();
        }
        return result;
    }
    
    public String getVowel(int vowelIdx) {
        switch (vowelIdx) {
            case 1: return "a";
            case 2: return "e";
            case 3: return "i";
            case 4: return "o";
            default: return "u";
        }
    }
}
