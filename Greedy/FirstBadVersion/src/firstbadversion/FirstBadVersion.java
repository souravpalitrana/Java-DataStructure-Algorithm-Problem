/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstbadversion;

/**
 *
 * @author souravpalit
 */
public class FirstBadVersion {

    /*// TC: O(N) SC: O(1) 
    // TLE
    public int firstBadVersion(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        
        return 1;
    }*/
    
    // TC: O(logn) SC: O(1)
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // With basic binary Search mid - 1, mid + 1;
    public int firstBadVersionAlternate(int n) {
        int left = 1;
        int right = n;
        int firstVeersion = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                firstVeersion = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return firstVeersion;  
    }
    
}
