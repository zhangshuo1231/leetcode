package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_256 {
    private int cost = Integer.MAX_VALUE;

    public int minCost(int[][] costs) {
        List<Integer> temp = new ArrayList<>();
        backtracking(temp, costs, costs.length);
        return cost;
    }

    private void backtracking(List<Integer> temp, int[][] costs, int numHouses) {
        if (temp.size() == numHouses) {
            int total = 0;
            for (int i = 0; i < numHouses; i++) {
                total += costs[i][temp.get(i)];
            }
            cost = Math.min(cost, total);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!temp.isEmpty() && temp.get(temp.size() - 1) == i) {
                continue;
            }
            temp.add(i);
            backtracking(temp, costs, numHouses);
            temp.remove(temp.size() - 1);
        }
    }
}
