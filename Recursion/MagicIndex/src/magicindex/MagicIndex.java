/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicindex;

/**
 * Time Complexity O(logn)
 * @author souravpalit
 */
public class MagicIndex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] array = {-10, -5, -1, 2, 3, 4, 5, 7, 9, 12, 13};
        findMagicIndex(array);
        
        int [] arrayWithDuplicates = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        findMagicIndexWithDuplicates(arrayWithDuplicates);
    }
    
    public static void findMagicIndex(int [] array) {
        int magicIndex = findMagicIndex(array, 0, array.length - 1);
        if (magicIndex == -1) {
            System.out.println("There is no magic number in the array");
        } else {
            System.out.println("The magic index is " + magicIndex);
        }
    }
    
    public static void findMagicIndexWithDuplicates(int [] array) {
        int magicIndex = findMagicIndexWithDuplicates(array, 0, array.length - 1);
        if (magicIndex == -1) {
            System.out.println("With Duplicates: There is no magic number in the array");
        } else {
            System.out.println("With Duplicates: The magic index is " + magicIndex);
        }
    }
    
    // Without duplicates
    public static int findMagicIndex(int [] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return findMagicIndex(array, start, mid);
        } else {
            return findMagicIndex(array, mid + 1, end);
        }
    }
    
    // With duplicates
    public static int findMagicIndexWithDuplicates(int [] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        
        if (array[mid] == mid) {
            return mid;
        }
        
        int left = Math.min(array[mid], mid - 1);
        int right = Math.max(array[mid], mid + 1);
        
        int magicIndexInLeft = findMagicIndexWithDuplicates(array, start, left);
        
        if (magicIndexInLeft != -1) {
            return magicIndexInLeft;
        }
        
        int magicIndexInRight = findMagicIndexWithDuplicates(array, right, end);
        
        if (magicIndexInRight != -1) {
            return magicIndexInRight;
        }
          
        return -1;
    }
    
}
