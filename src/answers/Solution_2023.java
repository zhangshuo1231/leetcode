package answers;

import java.util.HashMap;
import java.util.Map;

public class Solution_2023 {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : nums) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (String s : map.keySet()) {
            String right = missing(target, s);
            if (right == null) {
                continue;
            }
            else if (right.equals(s)) {
                res += map.get(s) * (map.get(s) - 1);
            }
            else {
                res += map.get(s) * map.getOrDefault(right, 0);
            }
        }
        return res;
    }

    private String missing(String target, String existing) {
        if (!target.startsWith(existing) || target.equals(existing)) {
            return null;
        }
        else {
            return target.substring(existing.length());
        }
    }
}
