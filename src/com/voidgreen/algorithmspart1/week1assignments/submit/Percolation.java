import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by y.shlapak on Sep 14, 2015.
 */
public class Percolation {

    private static final boolean FULL = false;
    private static final boolean OPEN = true;

    private boolean[][] grid;
    private int N;
    WeightedQuickUnionUF weightedQuickUnionUF;
    public Percolation(int N) { // create N-by-N grid, with all sites blocked
        if (N <= 0) throw new IllegalArgumentException ("N <= 0");
        weightedQuickUnionUF = new WeightedQuickUnionUF(N * N + 2);
        grid = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }
        this.N = N;
    }
    public void open(int i, int j) { // open site (row i, column j) if it is not open already
        int row = i - 1;
        int col = j - 1;
        check(row, col);
        grid[row][col] = OPEN;
        if (row == 0) { // If it's on the top row, connect to imaginary site at 0.
            weightedQuickUnionUF.union(0, xyTo1D(row, col));
        }
        if (row == N - 1) { // If it's on the bottom row, connect to imaginary
            // site at (N*N) + 1.
            weightedQuickUnionUF.union((N*N) + 1, xyTo1D(row, col));
        }
        if ((row + 1) < N) { // Make sure we don't fall off the grid
            if (grid[row+1][col] == OPEN)
                weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row+1, col));
        }
        if ((row - 1) >= 0) { // Make sure we don't fall off the grid
            if (grid[row-1][col] == OPEN)
                weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row-1, col));
        }
        if ((col + 1) < N) { // Make sure we don't fall off the grid
            if (grid[row][col+1] == OPEN)
                weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row, col+1));
        }
        if ((col - 1) >= 0) { // Make sure we don't fall off the grid
            if (grid[row][col-1] == OPEN)
                weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row, col-1));
        }
    }
    public boolean isOpen(int i, int j)  { // is site (row i, column j) open?
        int row = i - 1;
        int col = j - 1;
        check(row, col);
        return grid[row][col];
    }
    public boolean isFull(int i, int j) {    // is site (row i, column j) full?
        int row = i - 1;
        int col = j - 1;
        check(row, col);
        return weightedQuickUnionUF.connected(0, xyTo1D(row, col));
    }
    public boolean percolates() {

        return weightedQuickUnionUF.connected(0, (N*N)+1);
    }


    private int xyTo1D(int row, int col) {
        check(row, col);
        return row * this.N + col + 1;
    }

    private void showIndices(int row, int col) {
        //System.out.println(i);
        //System.out.println(j)
    }
    private void check(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N) throw new IndexOutOfBoundsException("row index i out of bounds");
    }

    public static void main(String[] args) {

    }
}