/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumbermnemonics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity is O(4^n * n) and Space Complexity is O(4^n * n)
 * For time maximum branch will be 4 as 9 and 7 has highest letters and if the 
 * digit is 9999 then for each 9 4 recursive call will made so it is 4^n and the 
 * additional n is for each number we need to join the numbers at last. Which 
 * takes n time. Same goes for space as well. 
 * @author souravpalit
 */
public class PhoneNumberMnemonics {

    public static Map<Character, String []> DIGIT_LETTERS = new HashMap<Character, String []>();
    
    static {
        DIGIT_LETTERS.put('0', new String [] {"0"});
        DIGIT_LETTERS.put('1', new String [] {"1"});
        DIGIT_LETTERS.put('2', new String [] {"a","b","c"});
        DIGIT_LETTERS.put('3', new String [] {"d", "e", "f"});
        DIGIT_LETTERS.put('4', new String [] {"g", "h", "i"});
        DIGIT_LETTERS.put('5', new String [] {"j", "k", "l"});
        DIGIT_LETTERS.put('6', new String [] {"m","n","o"});
        DIGIT_LETTERS.put('7', new String [] {"p","q", "r", "s"});
        DIGIT_LETTERS.put('8', new String [] {"t", "u", "v"});
        DIGIT_LETTERS.put('9', new String [] {"w","x","y","z"});
        
    }
    
    public static void main(String[] args) {
        String phoneNumber = "1905";
        ArrayList<String> mnemonicsPhoneNumbers = phoneNumberMnemonics(phoneNumber);
        for (String number : mnemonicsPhoneNumbers) {
            System.out.println(number);
        }
    }
    
    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        String [] currentMnemonics = new String [phoneNumber.length()];
        ArrayList<String> mnemonicsNumbers = new ArrayList<String>();
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonics, mnemonicsNumbers);
        return mnemonicsNumbers;
    }
    
    public static void phoneNumberMnemonicsHelper(int currentIdx, String phoneNumber, 
            String [] currentMnemonics, ArrayList<String> mnemonicsNumbers) {
        if (currentIdx == phoneNumber.length()) {
            String number = String.join("", currentMnemonics);
            mnemonicsNumbers.add(number);
        } else {
            String [] letters = DIGIT_LETTERS.get(phoneNumber.charAt(currentIdx));
        
        for (int i = 0; i < letters.length; i++) {
            currentMnemonics[currentIdx] = letters[i];
            phoneNumberMnemonicsHelper(currentIdx + 1, phoneNumber, currentMnemonics, mnemonicsNumbers);
        }
        }
    }
}
