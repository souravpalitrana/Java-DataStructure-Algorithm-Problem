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
public class CaesarCipherEncryptorAlternate {

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "abc";
        int key = 2;
        
        System.out.print(caesarCipherEncryptor(input, key));
    }
    
    public static String caesarCipherEncryptor(String text, int key) {
        int newKey = key % 26;
      
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            builder.append(getShiftedCharacter(newKey, text.charAt(i)));
        }
        
        return builder.toString();
    }
    
    public static char getShiftedCharacter(int key, char letter) {
        int letterIndex = alphabet.indexOf(letter) + key;
        
        return (char) alphabet.charAt(letterIndex % 26);
    }
    
}
