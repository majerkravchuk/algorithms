package Fundamentals.Implementations;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
    private static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1;
    }

    public static int slowCount(int[] a) {
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;

        return cnt++;
    }

    public static int fastCount(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;

        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (rank(-a[i]-a[j], a) > j)
                    cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        In in = new In("data/8Kints.txt");
        int[] a = in.readAllInts();
        StdOut.println(fastCount(a));
    }
}
