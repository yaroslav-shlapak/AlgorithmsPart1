package com.voidgreen.algorithmspart1.week2;

/**
 * Created by y.shlapak on Sep 18, 2015.
 */
public class LinkedStackOfStrings {

    private Node first = null;

    //linked-list node
    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //put string on top
    public void push(String s) {
        Node old = first;
        first = new Node();
        first.item = s;
        first.next = old;
    }

    //remove and return the top string
    public String pop() {
        String s = first.item;
        first = first.next;
        return s;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        stack.push("E");
        stack.push("X");
        stack.push("A");
        stack.push("M");
        stack.push("P");
        stack.push("L");
        stack.push("E");

        while (!stack.isEmpty()) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
