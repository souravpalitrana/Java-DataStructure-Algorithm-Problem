/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import java.util.ArrayList;

/**
 *
 * @author souravpalit
 */
public class Permutation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "ABC";
        ArrayList<String> allPermutation = calculate(input, input.length());
        
        for (String item : allPermutation) {
            System.out.println(item);
        }
    }
    
    public static ArrayList<String> calculate(String input, int n) {
        
        if (n == 1) {
            ArrayList<String> list = new ArrayList();
            list.add(String.valueOf(input.charAt(n-1)));
            return list;
        }
        
        ArrayList<String> items = calculate(input, n-1);
        ArrayList<String> newItems = insert(items, input.charAt(n-1));
        return newItems;
    }
    
    
    public static ArrayList<String> insert(ArrayList<String> items, char c) {
        ArrayList<String> newItems = new ArrayList<>();
        
        for (String item : items) {
            // Loop will go from 0 to length because we need to add at the end also
            for (int i = 0; i <= item.length(); i++) {
                newItems.add(addChar(item, c, i));
            }
        }
        
        return newItems;
    }
    
    public static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }
}
