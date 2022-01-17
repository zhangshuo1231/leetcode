package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_296 {
    public int minTotalDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }
        Collections.sort(rowList);
        Collections.sort(colList);
        return distance(new int[]{rowList.get(rowList.size() / 2), colList.get(colList.size() / 2)}, grid);
    }

    private int distance(int[] meeting, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int distance = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    distance += Math.abs(i - meeting[0]);
                    distance += Math.abs(j - meeting[1]);
                }
            }
        return distance;
    }
}
