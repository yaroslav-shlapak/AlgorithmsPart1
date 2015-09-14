package com.voidgreen.algorithmspart1.week1;

/**
 * Created by y.shlapak on Sep 14, 2015.
 */
public class Question1AlgorithmsAlnalysis {
    public static void main(String[] args) {
        int startNum = 2048;
        int endNum = 33554432;

        double s1 = 562.295, s2 = 1722.209;
        double n1 = 16777216;
        double n2 = 33554432;


        double power =  myLog(s1, n1) - myLog(s2 / s1, 2);
        double a = Math.pow(n1, power);
        double b = myLog(s2/ a, n2);

        System.out.println(power);
        System.out.println(a);
        System.out.println(b);

        for(int i = startNum; i <= endNum; i = 2 * i) {
            System.out.print(i + "\t\t\t");
            System.out.print(a * Math.pow(i, b) + "\t");
            System.out.println();
        }

        System.out.println(b);

    }


    public static double myLog(double n, double base) {
        return Math.log(n) / Math.log(base);

    }
}
