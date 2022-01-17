package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_305 {
    class UnionFind {
        int count; // # of connected components
        int[] parent;

        public UnionFind(int N) { // for problem 305 and others
            count = 0;
            parent = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = -1;
            }
        }

        public boolean isLand(int i) { // for problem 305
            return parent[i] >= 0;
        }

        public void setLand(int i) {
            if (parent[i] == -1)
            {
                parent[i] = i;
                ++count;
            }
        }

        public int find(int i) { // find and path compression
//            if (parent[i] != i) {
//                parent[i] = find(parent[i]);
//            }
//            return parent[i];
            if (parent[i] == i) {
                return i;
            }
            else {
                int next = find(parent[i]);
                parent[i] = next;
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

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];

            List<Integer> overlap = new ArrayList<>();
            if (r - 1 >= 0 && uf.isLand(getIdx(r - 1, c, n))) {
                overlap.add(getIdx(r - 1, c, n));
            }
            if (r + 1 < m && uf.isLand(getIdx(r + 1, c, n))) {
                overlap.add(getIdx(r + 1, c, n));
            }
            if (c - 1 >= 0 && uf.isLand(getIdx(r, c - 1, n))) {
                overlap.add(getIdx(r, c - 1, n));
            }
            if (c + 1 < n && uf.isLand(getIdx(r, c + 1, n))) {
                overlap.add(getIdx(r, c + 1, n));
            }

            int index = getIdx(r, c, n);
            uf.setLand(index);
            for (int i : overlap) {
                uf.union(i, index);
            }
            ans.add(uf.getCount());
        }
        return ans;
    }

    private int getIdx(int row, int col, int n) {
        return row * n + col;
    }
}