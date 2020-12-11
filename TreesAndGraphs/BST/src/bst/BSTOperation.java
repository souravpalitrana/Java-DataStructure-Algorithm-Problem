/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 * Binary search tree construct insert delete
 * @author souravpalit
 */
public class BSTOperation {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ///nt [] values = {5, 15};
        //int [] values = {5, 9, 7 , 4, 3, 11, 12, 6};
        //int [] values = {5, 15, 2 , 5, 13, 22, 1, 14, 12};
        int [] values =  {4,2,5,6};
        
        BST bst = new BST(10);
        
        for (int i = 0; i < values.length; i++) {
            bst.insert(values[i]);
        }
        
       
        System.out.println("Root node is = " + bst.value);
        
        //bst.remove3(10, null);
        
        for (int i = values.length -1; i >=0; i--) {
           System.out.println("Contains (" + values[i] + ") : " + bst.contains(values[i]));
        }
        System.out.println("Root node is = " + bst.value);
        
        
        //System.out.println("Now Root node is = " + bst.getValue());
    }
    
    
}
