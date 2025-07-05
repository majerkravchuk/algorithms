package Sorting;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionSortVisualization {
    private static void show(int a[], double maxValue) {
        show(a, maxValue, -1, -1, -1);
    }

    private static void show(int a[], double maxValue, int si, int ei, int ci) {
        StdDraw.pause(25);
        StdDraw.clear();
        int N = a.length;
        double hw = 1.0 / N / 4.0;
        for (int i = 0; i < N; i++) {
            if (i < si || i > ei ) {
                StdDraw.setPenColor(StdDraw.GRAY);
            } else if (i == ci) {
                StdDraw.setPenColor(StdDraw.RED);
            } else {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            double x = 1.0 * i / N + hw * 2;
            double hh = a[i] / maxValue / 2;
            double y = hh;
            StdDraw.filledRectangle(x, y, hw, hh);
        }
        StdDraw.show();
    }

    public static void sortAndShow(int[] a) {
        StdDraw.enableDoubleBuffering();
        double max = Arrays.stream(a).max().getAsInt();
        show(a, max);

        for (int i = 1; i < a.length; i++) {
            show(a, max, i, i, i);
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
                show(a, max, j-1, i, j-1);
            }
        }

        show(a, max);
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int N = 100;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniformInt(100);

        sortAndShow(a);
    }
}
