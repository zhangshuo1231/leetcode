package answers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue priorityQueue = new PriorityQueue<Integer>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                priorityQueue.add(matrix[row][col]);
            }
        }
        for (int i = 1; i <= k - 1 ; i++) {
            priorityQueue.poll();
        }
        return (int) priorityQueue.poll();
    }
}
