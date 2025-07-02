package Fundamentals.Interfaces;

public interface IUnionFind {
    void init(int N);
    void union(int p, int q);
    int find(int p);
    boolean connected(int p, int q);
    int count();
}
