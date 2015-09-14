package com.voidgreen.algorithmspart1.week1;

/**
 * Created by yaroslav on 9/13/15.
 */
public class Observation {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 4, 8, 16, 32, 64};
        // write your code here
        for(int i = 0; i < numbers.length; i++ ) {
            int num = 1000 * numbers[i];
            System.out.print(num + "\t");
            System.out.print((3.3 * Math.pow(10, -4) * num) + "\t");
            System.out.print((Math.pow(num, 2)) + "\t");
            System.out.print((5.0 * Math.pow(10, -9) * Math.pow(num, 2)) + "\t");
            System.out.println((6.25 * Math.pow(10, -9) * Math.pow(num, 2)) + "\t");
        }
    }
}
