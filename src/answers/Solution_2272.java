package answers;

import java.util.HashSet;
import java.util.Set;

public class Solution_2272 {
    public int largestVariance(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        int res = 0;
        for (char i : set) {
            for (char j : set) {
                if (i == j) {
                    continue;
                }
                int diff = 0;
                boolean jSeen = false, jStart = false;
                for (int idx = 0; idx < n; idx++) {
                    char curr = s.charAt(idx);
                    if (curr == i) {
                        diff++;
                    }
                    else if (curr == j) {
                        jSeen = true;
                        if (diff >= 0 && jStart) {
                            jStart = false;
                        }
                        else {
                            diff--;
                            if (diff < 0) {
                                jStart = true;
                                diff = -1;
                            }
                        }
                    }
                    else {
                        continue;
                    }
                    if (jSeen) {
                        res = Math.max(res, diff);
                    }
                }
            }
        }
        return res;
    }
}
