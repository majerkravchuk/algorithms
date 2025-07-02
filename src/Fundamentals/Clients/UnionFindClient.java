package Fundamentals.Clients;

import Fundamentals.Interfaces.IUnionFind;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindClient {
    private IUnionFind uf;

    public UnionFindClient(IUnionFind uf) {
        this.uf = uf;
    }

    public void Run(String file) {
        In in = new In(file);

        uf.init(in.readInt());

        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q))
                continue;

            uf.union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println(uf.count() + " components");
    }
}
