package Fundamentals.Clients;

import edu.princeton.cs.algs4.StdOut;
import Fundamentals.Interfaces.IBag;

public class BagClient {
    private IBag<String> bag;

    public BagClient(IBag<String> bag) {
        this.bag = bag;
    }

    public void Run() {
        bag.add("a");
        bag.add("b");
        bag.add("x");
        bag.add("y");
        bag.add("z");

        for (String string : bag) {
            StdOut.print(string);
        }

        StdOut.print("\n");
    }
}
