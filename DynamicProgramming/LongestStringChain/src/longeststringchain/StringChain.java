/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longeststringchain;

/**
 *
 * @author souravpalit
 */
public class StringChain {
    public String nextString;
    public int length;
    
    public StringChain(String nextString, int length) {
        this.nextString = nextString;
        this.length = length;
    }
}
