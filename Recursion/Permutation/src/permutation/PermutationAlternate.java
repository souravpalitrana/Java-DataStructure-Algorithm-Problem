/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

/**
 *
 * @author souravpalit
 */
public class PermutationAlternate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "ABCD";
        
        calculate(input, 0, input.length());
    }
    
    public static void calculate(String input, int left, int right) {
        if (left == right) {
            System.out.println(input);
        } else {
            for (int i = left; i < right; i++) {
                String swapped = swap(input, left, i);
                calculate(swapped, left + 1, right);
            }
        }
    }
    
    public static String swap(String input, int first, int second) {
        char [] inputChars = input.toCharArray();
        char temp = inputChars[first];
        inputChars[first] = inputChars[second];
        inputChars[second] = temp;
        return String.valueOf(inputChars);
    }
}
