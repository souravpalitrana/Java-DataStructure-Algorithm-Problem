/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversewordsinstring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class ReverseWordsInString {

    public static char SPACE = ' ';

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "a  b     c";
        //String str = "a ";
        //String str = "Sourav    is    a   good boy";
        //String str = "S";
        //String str = "this      string     has a     lot of   whitespace";
        //String str = "test     ";
        System.out.println(reverseWordsInString(str));
    }
    
    public static String reverseWordsInString(String str) {
        if (str.length() <= 1) {
            return str;
        }

        List<String> words = new ArrayList<String>();
        int wordStartIndx = 0;

        // If current character is space and previous is not space = character word
        // If current character is not space but previous character is space = space word
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == SPACE && str.charAt(i - 1) != SPACE
                    || str.charAt(i) != SPACE && str.charAt(i - 1) == SPACE) {
                words.add(str.substring(wordStartIndx, i));
                wordStartIndx = i;
            }
        }

        words.add(str.substring(wordStartIndx, str.length()));

        StringBuilder builder = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            builder.append(words.get(i));
        }

        return builder.toString();
    }
}
