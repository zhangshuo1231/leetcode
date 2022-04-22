package answers;

import java.util.TreeMap;

public class Solution_954 {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap((a, b) -> (Math.abs((int)a) - Math.abs((int)b)));

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 0) {
                continue;
            }
            else {
                while (map.get(i) > 0) {
                    if (!map.containsKey(i * 2) || map.get(i * 2) == 0) {
                        return false;
                    }
                    map.put(i, map.get(i) - 1);
                    map.put(i * 2, map.get(i * 2) - 1);
                }
            }
        }

        return true;
    }
}
