/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromepartitioningmincuts;

/**
 * Time Complexity: O(n^2) Space Complexity: O(n^2)
 * @author souravpalit
 */
public class PalindromePartitioningMinCutsOptimized {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String str = "noonabbad";
        System.out.println(palindromePartitioningMinCuts(str));
    }
    
    public static int palindromePartitioningMinCuts(String str) {
        boolean [][] palindrome = new boolean [str.length()][str.length()];
        
        // step: 1
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                palindrome[i][j] = (i == j);
            }
        }
		
        // Awesome technique: if first and last character is same and between
        // this two character the sub string is palindrome then we can say it 
        // is palindrome. So first we set all single character is palindrome 
        // before. Now we will start from length 2. So in case of 2 length if both
        // character is same then we can say it is palindrome. Now in case of 3 
        // character there is a middle character. If first and last character 
        // same and middle character is palindrome then we can say this substringg
        // is palindrome. This middle character we already calculated and stored
        // in our palindrome array(step:1). 
        // Now in case of length 4 if first and last character is same and all the
        // character between these two character must form a palindrome if it is
        // palindrome. So we are in length 3. When we calculated length 2 we already
        // stored all the possible palindrome of two characters. So we can use 
        // that result here to calculate 4 characters result.
        // Simularly in case of 5 character. There is 3 characters between. Which
        // we calculated when length is 3. Nice Yeah! :)
	for (int length = 2; length < str.length() + 1; length++) {
            for (int i = 0; i < str.length() - length + 1; i++) {
		int j = i + length - 1;
		if (length == 2) {
                    palindrome[i][j] = (str.charAt(i) == str.charAt(j));
		} else {
                    palindrome[i][j] = (str.charAt(i) == str.charAt(j) && palindrome[i + 1][j - 1]); 
		}
            }
	}
        
        int [] cuts = new int [str.length()];
        
        for (int i = 0; i < str.length(); i++) {
            if (palindrome[0][i]) {
                cuts[i] = 0;
            } else {
                cuts[i] = cuts[i - 1] + 1;
                
                for (int j = 1; j < i; j++) {
                    if (palindrome[j][i] && cuts[j - 1] + 1 < cuts[i]) {
                        cuts[i] = cuts[j - 1] + 1;
                    }
                }
            }
        }
        
        return cuts[cuts.length - 1];
    }
    
    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        
        return true;
    }
    
}
