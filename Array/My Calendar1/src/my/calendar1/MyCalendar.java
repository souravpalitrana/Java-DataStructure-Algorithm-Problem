/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.calendar1;

import java.util.Map;
import java.util.TreeMap;

/**
 * Leetcode: 729. My Calendar I
 * Problem Link: https://leetcode.com/problems/my-calendar-i/
 * @author souravpalit
 */
public class MyCalendar {
    
    private final TreeMap<Integer, Integer> bookedEventsMap;
    
    public MyCalendar() {
        bookedEventsMap = new TreeMap<>();
    }
    
    // TC: O(nlogn) where n is the previous booked events
    // SC: O(n)
    public boolean book(int start, int end) {       
        if (isNotOverlaped(start, end)) {
            bookedEventsMap.put(start, end);
            return true;
        }
        
        return false;
    }
    
    private boolean isNotOverlaped(int start, int end) {
        Integer prevStart = bookedEventsMap.floorKey(start); // Meeting age suru hoice 
        Integer prevStartNext = bookedEventsMap.ceilingKey(start);
        
        /// Not started any meeeting so end must complete start any meeting
        if (prevStart == null && prevStartNext == null) {
            return true;
        }
        // No meeting started so if this meeting ends before next meeting 
        if (prevStart == null && end <= prevStartNext) {
            return true;
        }
        // Previous meeting started. So this meeting must start after end of previous
        // meeting and this meeting must end before start of next meeting or no next meeting
        return prevStart != null && start >= bookedEventsMap.get(prevStart) &&
                (prevStartNext == null || end <= prevStartNext);
    }
}
