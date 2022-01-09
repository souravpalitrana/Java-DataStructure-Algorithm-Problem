/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcommonsubsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n * m) Space Complexity: O(n * m)
 * @author souravpalit
 */
public class LongestCommonSubsequenceFinalOptimized {

    public static void main(String[] args) {
        String str1 = "zxvvyzw";
        String str2 = "xkykzpw";
        List<Character> lcs = longestCommonSubsequence(str1, str2);
        for (char ch : lcs) {
            System.out.print(ch + "  ");
        }
        
    }
    
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int [][] lcs = new int [str1.length() + 1][str2.length() + 1];
        
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        
        return buildSequence(lcs, str1, str2);
    }
    
    public static List<Character> buildSequence(int [][] lcs, String str1, String str2) {
        List<Character> lcsCharList = new ArrayList<Character>();
        
        int i = lcs.length - 1;
        int j = lcs[0].length - 1;
        
        while (i != 0 && j != 0) {
            if (lcs[i][j] == lcs[i][j - 1]) {
                j--;
            } else if (lcs[i][j] == lcs[i - 1][j]) {
                i--;
            } else {
                lcsCharList.add(0, str1.charAt(i - 1));
                i--;
                j--;
            }
        }
        
        return lcsCharList;
    }
    
}
