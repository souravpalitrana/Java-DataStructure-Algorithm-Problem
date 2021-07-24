/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class PermutationExcercise {

    public static void main(String args[]) {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<List<Integer>> permutations = getPermutations(input);
        for (List<Integer> permutation : permutations) {
            for (Integer perm : permutation) {
                System.out.print(perm + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        generatePermutation(array, 0, permutations);
        return permutations;
    }

    public static void generatePermutation(List<Integer> input, int left, List<List<Integer>> permutations) {
        int end = input.size() - 1;
        if (left == end) {
            permutations.add(input);
        } else {
            for (int i = left; i <= end; i++) {
                List<Integer> swapped = swap(input, left, i);
                generatePermutation(swapped, left + 1, permutations);
            }
        }
    }

    public static List<Integer> swap(List<Integer> input, int left, int right) {
        List<Integer> newInput = new ArrayList<Integer>();
        newInput.addAll(input);
        int temp = newInput.get(left);
        newInput.set(left, input.get(right));
        newInput.set(right, temp);
        return newInput;
    }

}
