/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package continuousmedian;

import java.util.ArrayList;

/**
 *
 * @author souravpalit
 */
public class ContinuousMedianHandler {
    
    double median = 0;
    Heap lowers = new Heap(Heap.MAX_HEAP, new ArrayList<Integer>());
    Heap greaters = new Heap(Heap.MIN_HEAP, new ArrayList<Integer>());

    public void insert(int number) {
      if (lowers.size() == 0 || number < lowers.peek()) {
          lowers.insert(number);
      } else {
          greaters.insert(number);
      }
      rebalanceHeapIfRequired();
      updateMedian();
    }

    public double getMedian() {
      return median;
    }
    
    private void rebalanceHeapIfRequired() {
        // If lower and greater difference is 2 we need to balance
        if (lowers.size() - greaters.size() == 2) {
            greaters.insert(lowers.remove());
        } else if (greaters.size() - lowers.size() == 2) {
            lowers.insert(greaters.remove());
        }
    }
    
    private void updateMedian() {
        if (lowers.size() == greaters.size()) {
            median = ((double)(lowers.peek() + greaters.peek())) / 2;
        } else {
            median = (lowers.size() > greaters.size()) ? lowers.peek() : greaters.peek();
        }
    }
}
