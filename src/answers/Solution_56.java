package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) {
                int end = Math.max(curr[1], intervals[i][1]);
                curr[1] = end;
            }
            else {
                result.add(curr);
                curr = intervals[i];
            }
        }
        result.add(curr);
        return result.toArray(new int[result.size()][]);
    }
}
