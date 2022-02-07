package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pattern = new int[26];
        for (char c : p.toCharArray()) {
            pattern[c - 'a']++;
        }
        int[] test = new int[26];
        for (int i = 0; i < p.length(); i++) {
            test[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(test, pattern)) {
            res.add(0);
        }
        int pl = p.length();
        int sl = s.length();
        for (int i = 0, j = pl; j < sl; i++, j++) {
            test[s.charAt(i) - 'a']--;
            test[s.charAt(j) - 'a']++;
            if (Arrays.equals(test, pattern)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}

// cbaebabacd
