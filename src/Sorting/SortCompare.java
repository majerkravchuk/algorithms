package Sorting;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

enum Algorithm {
    Insertion,
    Selection,
    Shell
};

public class SortCompare {
    public static <T extends Comparable<T>> double time(Algorithm alg, T[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg == Algorithm.Insertion)
            Insertion.sort(a);
        else if (alg == Algorithm.Selection)
            Selection.sort(a);
        else if (alg == Algorithm.Shell)
            Shell.sort(a);
        // if (alg.equals("Shell"))
        //     Shell.sort(a);
        // if (alg.equals("Merge"))
        //     Merge.sort(a);
        // if (alg.equals("Quick"))
        //     Quick.sort(a);
        // if (alg.equals("Heap"))
        //     Heap.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(Algorithm alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniformDouble();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        Algorithm alg1 = Algorithm.Shell;
        Algorithm alg2 = Algorithm.Insertion;

        int N = 100000;
        int T = 1;

        double t1 = 0.0;
        double t2 = 0.0;

        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniformDouble();
            t1 += time(alg1, a.clone());
            t2 += time(alg2, a.clone());
        }

        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
