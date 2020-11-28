/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivemultiply;

/**
 * RecursiveMulltiply
 * @author souravpalit
 */
public class RecursiveMultiplyAlternate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 5;
        int b = 13;
        int result = minProduct(a,b);
        
        System.out.print("Multiplication result of " + a + " and " + b +" is : " + result);
    }
    
    static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }
    
    static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }
        
        int s = smaller >> 1;
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, bigger);
        }
        
        return side1 + side2;
    }
    
}
