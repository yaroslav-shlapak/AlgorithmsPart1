package com.voidgreen.algorithmspart1.week2;

import java.util.Arrays;

/**
 * Created by y.shlapak on Sep 21, 2015.
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0, minIndex = i; i < N; i++) {
            minIndex = getMin(a, i, N);
            exchange(a, i, minIndex);
        }
    }

    private static int getMin(Comparable[] a, int start, int length) {
        Comparable min = a[start];
        int minIndex = start;
        for(int i = start; i < length; i++) {
            if(less(a[i], min)) {
                min = a[i];
                minIndex = i;

            }
        }
        System.out.println(min);
        return minIndex;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;

    }

    public static void main(String[] args) {
        int N = 100;
        Integer[] a = new Integer[N];

        for(int i = 0; i < N; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.asList(a));
        sort(a);
        System.out.println(Arrays.asList(a));
    }
}
