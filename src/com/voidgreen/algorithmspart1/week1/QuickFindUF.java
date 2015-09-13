package com.voidgreen.algorithmspart1.week1;

import java.util.Arrays;

/**
 * Created by y.shlapak on Sep 11, 2015.
 */
public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {

        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pid) id[i] = qid;
        }
    }

    public void printId() {
        for(int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickFindUF qf = new QuickFindUF(10);
        qf.printId();
        qf.union(7, 0);
        qf.union(3, 5);
        qf.union(8, 0);
        qf.union(4, 1);
        qf.union(4, 6);
        qf.union(9, 6);
        qf.printId();
    }
}
