package com.voidgreen.algorithmspart1.week1;

import java.util.Arrays;

/**
 * Created by VOID on 12-09-15.
 */
public class QuickUnionUF {
    public int[] id;
    private int[] sz;
    public QuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void printId() {
        for(int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }

    private int root(int i) {
        while(i != id[i]) {
            //id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        //id[i] = j;
        if(i == j) return;
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        printId();
    }

    public static void main(String[] args) {
        QuickUnionUF qf = new QuickUnionUF(10);
        qf.printId();
        qf.union(3, 2);
        qf.union(0, 6);
        qf.union(5, 7);
        qf.union(1, 6);
        qf.union(0, 8);
        qf.union(2, 7);
        qf.union(1, 4);
        qf.union(6, 3);
        qf.union(3, 9);
        qf.printId();
    }
}
