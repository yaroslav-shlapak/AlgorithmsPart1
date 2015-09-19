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
