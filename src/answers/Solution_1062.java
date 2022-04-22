package answers;

import java.util.HashSet;
import java.util.Set;

public class Solution_1062 {
    public int longestRepeatingSubstring(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (isValid(s, mid)) {
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isValid(String s, int n) {
        if (n == 0) return false;
        Set<String> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len - n + 1; i++) {
            if (!set.add(s.substring(i, i + n))) {
                return true;
            }
        }
        return false;
    }
}
