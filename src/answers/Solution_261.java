package answers;

class UnionFind {

    private int[] parent;
    public UnionFind(int n) {
        parent = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
        }
    }
    public int find(int A) {
        while (parent[A] != A) {
            A = parent[A];
        }
        return A;
    }

    public boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        if (rootA == rootB) {
            System.out.println(rootA + " == " + rootB + ", false!");
            return false;
        }
        parent[rootA] = rootB;
        System.out.println("Set parent[" + rootA + "] to " + rootB);
        return true;
    }
}

public class Solution_261 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!unionFind.union(A, B)) {
                return false;
            }
        }
        return true;
    }
}
