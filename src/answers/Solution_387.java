package answers;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution_387 {
    public int firstUniqChar(String s) {
        Map<Character, int[]> map = new LinkedHashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[2]);
                map.get(c)[1] = i;
            }
            map.get(c)[0] += 1;
        }
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] == 1) {
                return entry.getValue()[1];
            }
        }
        return -1;
    }
}
