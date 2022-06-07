/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesortedarray;

import java.util.Arrays;

/**
 *
 * @author souravpalit
 */
public class MergeSortedArray {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Add nums2 at the end of nums1
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }

        // now sort nums1
        Arrays.sort(nums1);
    }
}

