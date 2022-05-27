/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designskiplist;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author souravpalit
 */
public class SkipList {

    private Node head;
    private int DUMMY_VALUE = -1;
    private Random randomGenerator;

    public SkipList() {
        head = new Node(DUMMY_VALUE); // dummy Node
        randomGenerator = new Random();
    }

    public boolean search(int target) {
        Node current = head;

        while (current != null) {
            while (current.next != null && current.next.val < target) {
                current = current.next;
            }

            if (current.next != null && current.next.val == target) {
                return true;
            }
            // Not found so go down
            current = current.down;
        }

        return false;
    }

    public void add(int target) {
        Stack<Node> path = new Stack<Node>();
        Node current = head;
        while (current != null) {
            while (current.next != null && current.next.val < target) {
                current = current.next;
            }

            path.push(current);
            current = current.down;
        }

        boolean goUp = true;
        Node down = null;

        while (goUp && !path.isEmpty()) {
            current = path.pop();
            current.next = new Node(target, current.next, down);
            down = current.next;
            goUp = getRandomNumber(1, 100) < 50;
        }
        
        if (goUp) {
            head = new Node(DUMMY_VALUE, null, head);;
        }

    }

    public boolean erase(int target) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            while (current.next != null && current.next.val < target) {
                current = current.next;
            }

            if (current.next != null && current.next.val == target) {
                found = true;
                current.next = current.next.next;
            }

            // May present down also
            current = current.down;
        }

        return found;
    }

    public int getRandomNumber(int min, int max) {
        return randomGenerator.nextInt(max - min) + min;
    }
}
