package com.voidgreen.algorithmspart1.week2;

import java.util.Iterator;

/**
 * Created by VOID on 19-09-15.
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first = null;

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {

        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    //linked-list node
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //put string on top
    public void push(Item item) {
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
    }

    //remove and return the top string
    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }
}
