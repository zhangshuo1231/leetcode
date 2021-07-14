package answers;

import java.util.*;

public class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> numFreqMap = new HashMap();
        for (int i : nums) {
            numFreqMap.putIfAbsent(i, 0);
            numFreqMap.put(i, numFreqMap.get(i) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numFreqMap.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
