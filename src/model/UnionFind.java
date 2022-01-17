package model;

public class UnionFind {
    int count; // # of connected components
    int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int i) { // find and path compression
        if (parent[i] == i) {
            return i;
        }
        else {
            int immediateParent = find(parent[i]);
            parent[i] = immediateParent;
            return parent[i];
        }
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
            --count;
        }
    }

    public int getCount() {
        return count;
    }
}
