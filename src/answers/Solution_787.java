package answers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int adjMatrix[][] = new int[n][n];
        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        int[] currBestCosts = new int[n];
        int[] currentStops = new int[n];
        Arrays.fill(currBestCosts, Integer.MAX_VALUE);
        Arrays.fill(currentStops, Integer.MAX_VALUE);
        currBestCosts[src] = 0;
        currentStops[src] = 0;

        // [node, cost, stops]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        minHeap.offer(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            int node = info[0], accumulatedCost = info[1], currNumStops = info[2];

            if (node == dst) {
                return accumulatedCost;
            }

            if (currNumStops > k) {
                continue;
            }

            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) {
                    int currBestCost = currBestCosts[nei], segmentCost = adjMatrix[node][nei];

                    if (accumulatedCost + segmentCost < currBestCost) {
                        minHeap.offer(new int[]{nei, accumulatedCost + segmentCost, currNumStops + 1});
                        currBestCosts[nei] = accumulatedCost + segmentCost;
                    }
                    else if (currNumStops < currentStops[nei]) {
                        minHeap.offer(new int[]{nei, accumulatedCost + segmentCost, currNumStops + 1});
                    }
                    currentStops[nei] = currNumStops;
                }
            }
        }

        return currBestCosts[dst] == Integer.MAX_VALUE ? -1 : currBestCosts[dst];
    }
}
