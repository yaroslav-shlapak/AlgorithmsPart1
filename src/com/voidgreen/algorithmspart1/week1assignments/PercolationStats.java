package com.voidgreen.algorithmspart1.week1assignments;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by y.shlapak on Sep 15, 2015.
 */
public class PercolationStats {

    private final int size;
    private final int numRuns;
    private final double[] results;
    private final double mean;
    private final double stddev;

    public PercolationStats(int size, int numRuns) {

        if (size <= 0 || numRuns <= 0) {
            throw new IllegalArgumentException();
        }

        this.size = size;
        this.numRuns = numRuns;
        this.results = new double[numRuns];
        run();
        // do mean and stddev once, not over and over for other stats
        this.mean = StdStats.mean(results);
        this.stddev = StdStats.stddev(results);
    }

    public double confidenceHi() {
        return mean - ((1.96 * stddev) / (Math.sqrt(numRuns)));
    }

    public double confidenceLo() {
        return mean - ((1.96 * stddev) / (Math.sqrt(numRuns)));
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    //
    // priv
    //

    private void run() {
        // outer loop numRuns
        for (int i = 0; i < numRuns; i++) {
            int numOpen = 0;
            Percolation perc = new Percolation(size);
            // inner loop add randoms to site and check for perc
            while (!perc.percolates()) {
                if (addRandomSite(perc)) {
                    numOpen++;
                }
            }
            double fractionOpen = (double) numOpen / (size * size);
            results[i] = fractionOpen;
        }
    }

    private boolean addRandomSite(Percolation perc) {
        // select a random site to OPEN
        int i = StdRandom.uniform(1, size + 1);
        int j = StdRandom.uniform(1, size + 1);
        if (!perc.isOpen(i, j)) {
            perc.open(i, j);
            return true;
        }
        return false;
    }

    //
    // main
    //

    public static void main(String[] args) {

        int size = 100;
        int numRuns = 200;

        PercolationStats stats = new PercolationStats(size, numRuns);

        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", "
                + stats.confidenceHi());
    }
}