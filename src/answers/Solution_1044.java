package answers;

import java.util.HashSet;
import java.util.Set;

public class Solution_1044 {
    public String longestDupSubstring(String s) {
        int l = 0, r = s.length();
        String found = "";
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            String curr = isValid(s, mid);
            if (!curr.equals("")) {
                l = mid;
                found = curr;
            }
            else {
                r = mid - 1;
            }
        }
        return found;
    }

    private String isValid(String s, int k) {
        if (k == 0 || k == s.length()) {
            return "";
        }

        for (int i = 0; i <= s.length() - k; i++) {
            String sample = s.substring(i, i + k);
            if (s.lastIndexOf(sample) != i) {
                return sample;
            }
        }
        return "";
    }
}
