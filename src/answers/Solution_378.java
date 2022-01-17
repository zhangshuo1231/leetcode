package answers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Coord> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        minHeap.offer(new Coord(0, 0, matrix[0][0]));
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int v = 0; v < k - 1; v++) {
            Coord top = minHeap.poll();
            if (top.i + 1 < matrix.length && !visited[top.i + 1][top.j]) {
                visited[top.i + 1][top.j] = true;
                minHeap.offer(new Coord(top.i + 1, top.j, matrix[top.i + 1][top.j]));
            }
            if (top.j + 1 < matrix[0].length && !visited[top.i][top.j + 1]) {
                visited[top.i][top.j + 1] = true;
                minHeap.offer(new Coord(top.i, top.j + 1, matrix[top.i][top.j + 1]));
            }
        }
        return minHeap.peek().val;
    }
}

class Coord {
    int i, j, val;
    public Coord (int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
