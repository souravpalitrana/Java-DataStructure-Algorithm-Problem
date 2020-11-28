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
public class RecursiveMultiply {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 7;
        int b = 17;
        System.out.print("Multiplication result of " + a + " and " + b +" is : ");
        multiply(a,b,0);
    }
    
    private static void multiply(int a, int b, int result) {
        if (result == 0 && (a == 0 || b == 0)) {
            System.out.println("0");
        } else if (result == 0 && a == 1) {
            System.out.println(b);
        } else if (b == 1 && result == 0) {
            System.out.println(a);
        } else if (b == 0) {
            System.out.println(result);
        } else {
            
            if ( b % 2 == 1) {
                result = result + a;
            }
            a = a << 1;
            b = b >> 1;
            
            
            
            multiply(a,b,result);    
        }
    }
}
