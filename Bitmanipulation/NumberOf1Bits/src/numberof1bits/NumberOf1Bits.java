/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberof1bits;

/**
 *
 * @author souravpalit
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int mask = 1;
        int bits = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }

        return bits;
    }

}
