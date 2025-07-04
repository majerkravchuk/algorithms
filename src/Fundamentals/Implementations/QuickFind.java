package Fundamentals.Implementations;

import Fundamentals.Clients.UnionFindClient;
import Fundamentals.Interfaces.IUnionFind;

public class QuickFind implements IUnionFind {
    private int[] ids;
    private int count;

    public void init(int count) {
        this.count = count;
        this.ids = new int[count];

        for (int i = 0; i < count; i++)
            ids[i] = i;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < ids.length; i++)
            if (ids[i] == pId)
                ids[i] = qId;

        count--;
    }

    public int find(int p) {
        return ids[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        new UnionFindClient(new QuickFind()).Run("data/mediumUF.txt");
    }
}
