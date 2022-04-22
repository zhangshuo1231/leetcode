package answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2025 {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = nums[0];
        Map<Integer, Integer> count = new HashMap<>();
        count.put(pref[0], 1);

        for (int i = 1; i < n - 1; i++) {
            pref[i] = pref[i - 1] + nums[i];
            count.put(pref[i], count.getOrDefault(pref[i], 0) + 1);
        }
        pref[n - 1] = pref[n - 2] + nums[n - 1];

        int sum = pref[n - 1];
        int max = 0;
        if (sum % 2 == 0) {
            max = count.getOrDefault(sum / 2, 0);
        }

        Map<Integer, Integer> countPrev = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = k - nums[i];
            int changedSum = sum + diff;
            if (changedSum % 2 == 0) {
                max = Math.max(max, count.getOrDefault(changedSum / 2 - diff, 0) + countPrev.getOrDefault(changedSum / 2, 0));
            }
            count.put(pref[i], count.getOrDefault(pref[i], 0) - 1);
            countPrev.put(pref[i], countPrev.getOrDefault(pref[i], 0) + 1);
        }
        return max;
    }
}
