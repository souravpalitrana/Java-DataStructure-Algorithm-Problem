/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcipherencryptor;

/**
 * Time Complexity: O(n) Space Complexity O(n)
 * @author souravpalit
 */
public class CaesarCipherEncryptor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "abc";
        int key = 2;
        
        System.out.print(caesarCipherEncryptor(input, key));
    }
    
    public static String caesarCipherEncryptor(String text, int key) {
        
        int start = 96;
        int end = 122;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int charCode = text.charAt(i) + getShiftingKey(key);
            if (charCode > end) {
                charCode = charCode - end;
                charCode = start + charCode;
            }
            char newChar = (char) charCode;
            builder.append(newChar);
        }
        
        return builder.toString();
    }
    
    public static int getShiftingKey(int key) {
        int start = 96;
        int end = 122;
        int totalCharacter = 26;
        
        int shiftingKey = key % totalCharacter;
        
        return shiftingKey;
    }
    
}
