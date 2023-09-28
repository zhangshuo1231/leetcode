package answers;

import java.util.*;

public class Solution_2184 {
    List<HashSet<Integer>> singleLayerCombinations = new ArrayList<>();

    public int buildWall(int height, int width, int[] bricks) {
        dfs(bricks, new HashSet<>(), 0, width);
        HashMap<Integer, List<Integer>> nextsMap = new HashMap<>();
        for (int i = 0; i < singleLayerCombinations.size(); i++) {
            if (singleLayerCombinations.get(i).size() == 0) {
                if (!nextsMap.containsKey(i)) {
                    nextsMap.put(i, new ArrayList<>());
                }
                nextsMap.get(i).add(i);
            }
            for (int j = i + 1; j < singleLayerCombinations.size(); j++) {
                if (valid(singleLayerCombinations.get(i), singleLayerCombinations.get(j))) {
                    if (!nextsMap.containsKey(i)) {
                        nextsMap.put(i, new ArrayList<>());
                    }
                    if (!nextsMap.containsKey(j)) {
                        nextsMap.put(j, new ArrayList<>());
                    }
                    nextsMap.get(i).add(j);
                    nextsMap.get(j).add(i);
                }
            }
        }

        int[] dp1 = new int[singleLayerCombinations.size()];
        int[] dp2 = new int[singleLayerCombinations.size()];
        Arrays.fill(dp1, 1);
        int ans = 0;
        int mod = 1000000000 + 7;
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < singleLayerCombinations.size(); j++) {
                List<Integer> pair = nextsMap.get(j);
                dp2[j] = 0;
                if (pair != null) {
                    for (int p : pair) {
                         dp2[j] += dp1[p];
                         dp2[j] %= mod;
                    }
                }
            }
            for (int k = 0; k < singleLayerCombinations.size(); k++) {
                dp1[k] = dp2[k];
            }
        }
        for (int i : dp1) {
             ans += i;
             ans %= mod;
        }
        return ans;
    }

    boolean valid(HashSet<Integer> a, HashSet<Integer> b) {
        for (int i : a) {
            if (b.contains(i)) return false;
        }
        return true;
    }

    private void dfs(int[] bricks, HashSet<Integer> s, int sum, int width) {
        if (sum > width) {
            return;
        }
        else if (sum == width) {
            s.remove(sum);
            HashSet<Integer> tmp = new HashSet<>();
            for (int i : s) {
                tmp.add(i);
            }
            singleLayerCombinations.add(tmp);
            return;
        }
        else {
            for (int i = 0; i < bricks.length; i++) {
                s.add(sum + bricks[i]);
                dfs(bricks, s, sum + bricks[i], width);
                s.remove(sum + bricks[i]);
            }
        }
    }
}
