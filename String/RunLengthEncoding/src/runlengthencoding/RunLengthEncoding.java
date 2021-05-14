/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runlengthencoding;

/**
 * Time Complexity O(n) Space Complexity O(n)
 * @author souravpalit
 */
public class RunLengthEncoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String str = "AAAAAAAAAAAAABBCCCCDD";
        String str = "a";
        
        System.out.println(runLengthEncoding(str));
    }
    
    public static String runLengthEncoding(String str) {
        if (str.length() == 1) {
            return "1" + str;
        }
        char prev = str.charAt(0);
        int count = 1;
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            if (i == str.length() - 1) {
                if (current == prev) {
                    count++;
                    builder.append(getEncodedString(prev, count));
                } else {
                    builder.append(getEncodedString(prev, count));
                    builder.append(1 + "" + current);
                }
                
            } else if (current == prev) {
                count++;
            } else {
                builder.append(getEncodedString(prev, count));
                prev = current;
                count = 1;
            }
        }
        
        return builder.toString();
    }
    
    public static String getEncodedString(char letter, int count) {
        if (count <= 9) {
            return count + "" + letter;
        } else {
            int mod = count % 9;
            int total9 = (count - mod) / 9;
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= total9; i++) {
                builder.append("9" + letter);
            }
            
            if (mod != 0) {
                builder.append(mod + ""+ letter);
            }
            
            return builder.toString();
        }
    }
    
}
