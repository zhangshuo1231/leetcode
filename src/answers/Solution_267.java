package answers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] map = new int[26];
        int odd = 0;
        for (char c : s.toCharArray()) {
            map[c - 97]++;
            if (map[c - 97] % 2 == 1) {
                odd++;
            }
            else {
                odd--;
            }
        }
        if (odd > 1) return res;
        String tmp = "";
        for (int i = 0; i < 26 ; i++) {
            if (map[i] % 2 == 1) {
                tmp += (char) (i + 97);
                map[i]--;
                break;
            }
        }
        helper(res, tmp, map, s.length());
        return res;
    }

    private void helper(List<String> res, String tmp, int[] map, int n) {
        if (tmp.length() == n) {
            res.add(tmp);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                map[i] -= 2;
                helper(res, (char) (i + 97) + tmp + (char) (i + 97), map, n);
                map[i] += 2;
            }
        }
    }
}

