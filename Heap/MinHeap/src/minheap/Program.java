/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minheap;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class Program {

     public static void main(String[] args) {
        List<Integer> list = Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41);
        MinHeap minHeap = new MinHeap(list);
        for (Integer value : minHeap.heap) {
            System.out.print(value + " ");
        }
    }
}
