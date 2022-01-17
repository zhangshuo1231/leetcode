package answers;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();

        int left = 0, right = 0, lastChange = 0, max = 1;
        Set<Character> set = new LinkedHashSet<>();
        set.add(chars[0]);

        for (right = 1; right < chars.length; right++) {
            if (chars[right] != chars[right - 1]) {
                if (!set.contains(chars[right])) {
                    if (set.size() >= 2) {
                        set.clear();
                        set.add(chars[lastChange]);
                        set.add(chars[right]);
                        left = lastChange;
                    }
                    else {
                        set.add(chars[right]);
                    }
                }
                max = Math.max(max, right - left + 1);
                lastChange = right;
            }
            else {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}
