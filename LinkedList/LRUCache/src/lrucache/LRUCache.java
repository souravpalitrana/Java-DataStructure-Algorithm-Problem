/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class LRUCache {
    
    int maxSize;
    int currentSize = 0;
    DoublyLinkedList mostRecentList = new DoublyLinkedList();
    Map<String, DoublyLinkedListNode> cache = new HashMap<String, DoublyLinkedListNode>();
    
    public LRUCache(int maxSize) {
        this.maxSize = (maxSize > 1) ? maxSize : 1;
    }
    
    // T: O(1) S: O(1)
    public void insertKeyValuePair(String key, int value) {
        if (cache.containsKey(key)) {
            replaceKey(key, value);
        } else {
            if (currentSize == maxSize) {
                removeLeastRecentUsed();
                // Not incrementing current size as we remove the tail and adding
                // a new value. So the size will be the same.
            } else {
                currentSize++;
            }
            cache.put(key, new DoublyLinkedListNode(key, value));
        }
        
        updateMostRecent(cache.get(key));
    }
    
    // T: O(1) S: O(1)
    public LRUResult getValueFromKey(String key) {
      if (cache.containsKey(key)) {
          updateMostRecent(cache.get(key));
          return new LRUResult(true, cache.get(key).value);
      } else {
          return new LRUResult(false, -1);
      }
    }
    
    // T: O(1) S: O(1)
    public String getMostRecentKey() {
      if (mostRecentList.head == null) {
          return "";
      } else {
          return mostRecentList.head.key;
      }
    }
    
    private void replaceKey(String key, int value) {
        if (!cache.containsKey(key)) {
            return;
        }
        cache.get(key).value = value;
    }
    
    private void updateMostRecent(DoublyLinkedListNode node) {
        mostRecentList.setHead(node);
    }
    
    private void removeLeastRecentUsed() {
        String keyToRemove = mostRecentList.tail.key;
        mostRecentList.removeTail();
        cache.remove(keyToRemove);
    }
    
    static class LRUResult {

        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
}
