/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefixandsuffixsearch;

/**
 *
 * @author souravpalit
 */
public class PrefixAndSuffixSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String [] words = {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"};
        WordFilter filter = new WordFilter(words);
        System.out.println(filter.f("bccbacbcba","a"));
        
    }
    
}
