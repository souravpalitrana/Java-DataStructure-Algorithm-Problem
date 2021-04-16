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
public class RunLengthEncodingAlternate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String str = "AAAAAAAAAAAAABBCCCCDD";
        //String str = "a";
        
        System.out.println(runLengthEncoding(str));
    }
    
    public static String runLengthEncoding(String str) {
        int count = 1;
        StringBuilder builder = new StringBuilder();
        
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            char prev = str.charAt(i - 1);
            
            if (current != prev || count == 9) {
                builder.append(count);
                builder.append(prev);
                count = 0;
            }
            
            count++;
        }
        
        // In this logic last letter will be ignored. So need to append
        builder.append(count);
        builder.append(str.charAt(str.length() - 1));
        
        return builder.toString();
    }
}
