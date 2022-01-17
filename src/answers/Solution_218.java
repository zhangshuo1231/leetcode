package answers;

import java.util.*;

public class Solution_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        for (int[] points : buildings) {
            buildLines.add(new int[]{points[0], -points[2]});
            buildLines.add(new int[]{points[1], points[2]});
        }
        Collections.sort(buildLines, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            else {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(0);
        int preHighest = 0;
        for (int[] points : buildLines) {
            if (points[1] < 0) {
                maxHeap.add(-points[1]);
            }
            else {
                maxHeap.remove(points[1]);
            }
            int currHeight = maxHeap.peek();
            if (currHeight != preHighest) {
                res.add(Arrays.asList(points[0], currHeight));
                preHighest = currHeight;
            }
        }
        return res;
    }
}
