/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lrucache;

/**
 *
 * @author souravpalit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("c", 3);
        lruCache.insertKeyValuePair("d", 4);
        lruCache.getValueFromKey("a");
        lruCache.insertKeyValuePair("e", 5);
        lruCache.getValueFromKey("a");
        lruCache.getValueFromKey("b");
        lruCache.getValueFromKey("c");
        lruCache.insertKeyValuePair("f", 5);
        lruCache.getValueFromKey("c");
        lruCache.getValueFromKey("d");
        lruCache.insertKeyValuePair("g", 5);
        lruCache.insertKeyValuePair("a", 2);
        System.out.println(lruCache.mostRecentList.head.value);
    }
    
}
