package me.fycus.codeM2018;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        double maxHappy = 0;
        int maxIndex = 0;

        for (int i = 0; i < k; i++) {
            double a = in.nextInt();
            double b = in.nextInt();
            double happy = a * m / n + b * (n - m) / n;
            if (happy >= maxHappy) {
                maxHappy = happy;
                maxIndex = i;
            }
        }

        for (int i = 0; i < k; i++) {
            if (i != maxIndex)
                System.out.print(0);
            else
                System.out.print(n);
            if (i != k - 1)
                System.out.print(" ");
        }
    }
}
