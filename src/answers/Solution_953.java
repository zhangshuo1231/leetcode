package answers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_953 {
    public boolean isAlienSorted(String[] words, String order) {
        String[] sorted = new String[words.length];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        System.arraycopy(words, 0, sorted, 0, words.length);

        Arrays.sort(sorted, (a, b) -> {
            if (a.equals(b)) {
                return 0;
            }
            int i = 0;
            while (i < a.length() && i < b.length()) {
                char ca = a.charAt(i);
                char cb = b.charAt(i);
                if (ca == cb) {
                    continue;
                }
                else if (map.get(ca) < map.get(cb)) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            if (a.length() < b.length()) {
                return -1;
            }
            else {
                return 1;
            }
        });

        return Arrays.equals(words, sorted);
    }
}
