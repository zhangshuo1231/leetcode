package answers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_1834 {
    public int[] getOrder(int[][] tasks) {
        int[][] tasksWithIdx = new int[tasks.length][tasks[0].length];
        for (int i = 0; i < tasks.length; i++) {
            tasksWithIdx[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasksWithIdx, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1] != 0 ? a[1] - b[1] : a[2] - b[2]));

        int[] res = new int[tasks.length];
        int resIdx = 0;

        int currBar = tasksWithIdx[0][0];
        int pointer = 0;

        while (pointer < tasksWithIdx.length) {
            if (queue.isEmpty() && currBar < tasksWithIdx[pointer][0]) {
                currBar = tasksWithIdx[pointer][0];
            }
            while (pointer < tasksWithIdx.length && tasksWithIdx[pointer][0] <= currBar) {
                queue.offer(tasksWithIdx[pointer++]);
            }
            int[] task = queue.poll();
            res[resIdx++] = task[2];
            currBar += task[1];
        }
        while (!queue.isEmpty()) {
            int[] task = queue.poll();
            res[resIdx++] = task[2];
        }
        return res;
    }
}
