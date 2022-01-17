package answers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int res = 1;
        for (int i = 0; i < intervals.length; i++) {
            while (!queue.isEmpty() && queue.peek()[1] <= intervals[i][0]) {
                queue.poll();
            }
            queue.add(intervals[i]);
            res = Math.max(res, queue.size());
        }
        return res;
    }
}
