/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianoftwosortedarrays;

/**
 *
 * @author souravpalit
 */
public class MedianOfTwoSortedArrays {

    // Time Complexity: O(m + n) Space Complexity: O(m + n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] mergeNums = mergeNums(nums1, nums2);
        if (mergeNums.length % 2 == 1) {
            int mid = (int) Math.ceil(mergeNums.length / 2.0);
            return mergeNums[mid - 1];
        } else {
            int mid = mergeNums.length / 2;
            return (mergeNums[mid] + mergeNums[mid - 1]) / 2.0;
        }
    }
    
    private int [] mergeNums(int[] nums1, int[] nums2) {
        int [] mergeNums = new int [nums1.length + nums2.length];
        int nums1Idx = 0;
        int nums2Idx = 0;
        int mergeIdx = 0;
        while (nums1Idx < nums1.length || nums2Idx < nums2.length) {
            if (nums1Idx < nums1.length && nums2Idx < nums2.length) {
                if (nums1[nums1Idx] > nums2[nums2Idx]) {
                    mergeNums[mergeIdx] = nums2[nums2Idx];
                    nums2Idx++;
                } else {
                    mergeNums[mergeIdx] = nums1[nums1Idx];
                    nums1Idx++;
                }
            } else if (nums1Idx < nums1.length) {
                mergeNums[mergeIdx] = nums1[nums1Idx];
                nums1Idx++;
            } else {
                mergeNums[mergeIdx] = nums2[nums2Idx];
                nums2Idx++;
            }
            
            mergeIdx++;
        }
        
        return mergeNums;
    }
    
    
    // Time Complexity: O(m + n) Space Complexity: O(1)
    public double findMedianSortedArraysFirstAlternate(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        } else if (nums1.length == 1 && nums2.length == 0) {
            return nums1[0];
        } else if (nums2.length == 1 && nums1.length == 0) {
            return nums2[0];
        }
        
        int nums1Idx = 0;
        int nums2Idx = 0;
        int mergeIdx = 0;
        int previous = 0;
        int current = 0;
        int n = nums1.length + nums2.length;
        int mid = (int) Math.ceil(n / 2.0);
        boolean isOdd = n % 2 == 1;
        
        while (nums1Idx < nums1.length || nums2Idx < nums2.length) {
            previous = current;
            if (nums1Idx < nums1.length && nums2Idx < nums2.length) {
                if (nums1[nums1Idx] > nums2[nums2Idx]) {
                    current = nums2[nums2Idx];
                    nums2Idx++;
                } else {
                    current= nums1[nums1Idx];
                    nums1Idx++;
                }
            } else if (nums1Idx < nums1.length) {
                current = nums1[nums1Idx];
                nums1Idx++;
            } else {
                current = nums2[nums2Idx];
                nums2Idx++;
            }
            
            if (mergeIdx == mid) {
                break;
            }
            
            mergeIdx++;
        }
        
        return isOdd ? previous : (current + previous) / 2.0;
    }
    
    // Time Complexity: O(logn) Space Complexity: O(1)
    public double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // Ensuring nums1 is smaller or equal than nums2
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int lengthOfNums1 = nums1.length;
        int lengthOfNums2 = nums2.length;
        
        int low = 0;
        int high = lengthOfNums1;
        boolean isOdd = (lengthOfNums1 + lengthOfNums2) % 2 == 1;
        
        while (low <= high) {
            int partitionInNums1 = (low + high) / 2;
            int partitionInNums2 = ((lengthOfNums1 + lengthOfNums2 + 1) / 2) - partitionInNums1;     
            int maxLeftInNums1 = (partitionInNums1 == 0) ? Integer.MIN_VALUE : nums1[partitionInNums1 - 1];
            int minRightInNums1 = (partitionInNums1 == lengthOfNums1) ? Integer.MAX_VALUE : nums1[partitionInNums1];
            int maxLeftInNums2 = (partitionInNums2 == 0) ? Integer.MIN_VALUE : nums2[partitionInNums2 - 1];
            int minRightInNums2 = (partitionInNums2 == lengthOfNums2) ? Integer.MAX_VALUE : nums2[partitionInNums2];
            
            if (maxLeftInNums1 <= minRightInNums2 && maxLeftInNums2 <= minRightInNums1) {
                if (isOdd) {
                    return Math.max(maxLeftInNums1, maxLeftInNums2);
                } else {
                    return (Math.max(maxLeftInNums1, maxLeftInNums2) + Math.min(minRightInNums1, minRightInNums2)) / 2.0;
                }
            } else if (maxLeftInNums1 > minRightInNums2) {
                high = partitionInNums1 - 1;
            } else {
                low = partitionInNums1 + 1;
            } 
        }
        return 0.0;
    }
}
