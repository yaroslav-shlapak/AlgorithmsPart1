package com.voidgreen.algorithmspart1.week1;

/**
 * Created by VOID on 13-09-15.
 */
public class ThreeSum {

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    if(a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

/*    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        System.out.println(count(a));
    }*/
}
