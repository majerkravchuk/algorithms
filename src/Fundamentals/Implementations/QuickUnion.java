package Fundamentals.Implementations;

import Fundamentals.Clients.UnionFindClient;
import Fundamentals.Interfaces.IUnionFind;

public class QuickUnion implements IUnionFind {
    private int[] ids;
    private int count;

    public void init(int count) {
        this.count = count;
        this.ids = new int[count];

        for (int i = 0; i < count; i++)
            ids[i] = i;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        ids[pRoot] = qRoot;

        count--;
    }

    public int find(int p) {
        while (p != ids[p])
            p = ids[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        new UnionFindClient(new QuickUnion()).Run("data/largeUF.txt");
    }
}
