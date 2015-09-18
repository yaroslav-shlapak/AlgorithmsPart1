package com.voidgreen.algorithmspart1.week2;

/**
 * Created by y.shlapak on Sep 18, 2015.
 */
public class FixedCapacityStackOfStrings {

    private String[] data;
    private int N;

    public FixedCapacityStackOfStrings(int capacity) {
        data = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        data[N++] = item;
    }

    public String pop() {
        String item = data[--N];
        data[N] = null;
        return item;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
        stack.push("F");
        stack.push("I");
        stack.push("X");
        stack.push("E");
        stack.push("D");
        stack.push("S");
        stack.push("T");
        stack.push("A");
        stack.push("C");
        stack.push("K");

        while (!stack.isEmpty()) {
            System.out.printf("%s ",stack.pop());
        }
    }
}