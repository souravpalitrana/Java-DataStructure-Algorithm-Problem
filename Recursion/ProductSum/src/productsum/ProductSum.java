/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productsum;

import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity : O(n) Space Complexity: O(d) where n is the number of elements
 * and d is the highest depth of the special array in the array
 * @author souravpalit
 */
public class ProductSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Object> array = new ArrayList<Object>();
        array.add(5);
        array.add(2);
        
        List<Object> array1 = new ArrayList<Object>();
        array1.add(7);
        array1.add(-1);
        
        array.add(array1);
        array.add(3);
               
        List<Object> array2 = new ArrayList<Object>();
        array2.add(-13);
        array2.add(8);
        
        List<Object> array3 = new ArrayList<Object>();
        array3.add(6);
        array3.add(array2);
        array3.add(4);
        
        array.add(array3);
        
        System.out.println("Product Sum is : " + calculateProductSum(array));
    }
    
    public static int calculateProductSum(List<Object> array) {
        return calculateProductSum(array, 1);
    }
    
    public static int calculateProductSum(List<Object> array, int multiplier) {
        int sum = 0;
       
        for (Object object : array) {
            if (object instanceof ArrayList) {
                sum += calculateProductSum((ArrayList<Object>)object, multiplier + 1);
                System.out.println("Sum inside if :" + sum);
            } else {
                
                sum +=  (Integer)object;
                System.out.println("Multiplier = " + multiplier + "  Value = " + object + "  Sum inside  :" + sum);
            }
        }
        
        return multiplier * sum;
    }
    
}