package answers;

import java.util.*;

public class Solution_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }

        Collection<Integer> collection = map.values();
        Collections.sort((ArrayList)collection);

        int removed = 0, cnt = 0;
        for (Integer i : collection) {
            if (removed + i <= k) {
                removed += i;
            }
            cnt++;
        }

        return map.size() - cnt;
    }
}
