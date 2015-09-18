package com.voidgreen.algorithmspart1.week2;

/**
 * Created by y.shlapak on Sep 18, 2015.
 */
public class ResizingArrayStackOfStrings {

    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        //check the size (grow)
        if (N == s.length)
            resize(2 * s.length); //repeated doubling

        s[N++] = item;
    }

    public String pop(){
        String item = s[--N];
        s[N] = null;

        //check the size (shrink)
        if (N > 0 && N == s.length/4)
            resize(s.length / 2);

        return item;
    }

    private void resize(int capacity) {
        //cost of inserting first N items is ~ 3N
        String[] copy = new String[capacity];

        for (int i=0; i < N; i++)
            copy[i] = s[i]; //copy items

        s = copy;
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        stack.push("R");
        stack.push("E");
        stack.push("S");
        stack.push("I");
        stack.push("Z");
        stack.push("I");
        stack.push("N");
        stack.push("G");
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
