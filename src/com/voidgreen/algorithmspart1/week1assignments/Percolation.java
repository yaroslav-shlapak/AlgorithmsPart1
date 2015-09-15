package com.voidgreen.algorithmspart1.week1assignments;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by y.shlapak on Sep 14, 2015.
 */
public class Percolation {
    private boolean[][] grid;
    private int N;
    WeightedQuickUnionUF weightedQuickUnionUF;
    public Percolation(int N) { // create N-by-N grid, with all sites blocked
        if (N <= 0) throw new IllegalArgumentException ("N <= 0");
        weightedQuickUnionUF = new WeightedQuickUnionUF(N);
        grid = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
        this.N = N;
    }
    public void open(int i, int j) { // open site (row i, column j) if it is not open already
        i--;
        j--;
        check(i, j);
        grid[i][j] = true;
    }
    public boolean isOpen(int i, int j)  { // is site (row i, column j) open?
        i--;
        j--;
        check(i, j);
        return grid[i][j];
    }
    public boolean isFull(int i, int j) {    // is site (row i, column j) full?
        i--;
        j--;
        check(i, j);
        if(i > 1)
            return grid[i - 1][j];
        else
            return grid[i][j];
    }
    public boolean percolates() {

        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(isOpen(row, col)) {
                    weightedQuickUnionUF.union();
                }
            }
        }
    }

    private void check(int i, int j) {
        if (i <= 0 || i > N || j <= 0 || j > N) throw new IndexOutOfBoundsException("row index i out of bounds");
    }
}