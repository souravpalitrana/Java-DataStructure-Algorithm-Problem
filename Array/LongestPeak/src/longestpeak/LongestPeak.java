/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestpeak;

/**
 * Time Complexity O(n) and Space Complexity O(1)
 * @author souravpalit
 */
public class LongestPeak {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] input =  {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println("Longest Peak : " + longestPeak(input));
    }

    public static int longestPeak(int[] array) {
        // Write your code here.
        int maxPeakCount = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                int leftCount = giveLeftCount(array, i - 1);
                int rightCount = giveRightCount(array, i + 1);
                int count = leftCount + 1 + rightCount;
                maxPeakCount = Math.max(maxPeakCount, count);
                i += rightCount;
            }
        }
        return maxPeakCount;
    }

    public static int giveLeftCount(int[] array, int startPosition) {
        int count = 0;
        for (int i = startPosition; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static int giveRightCount(int[] array, int startPosition) {
        int count = 0;
        for (int i = startPosition; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

}
