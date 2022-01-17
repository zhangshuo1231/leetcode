package answers;

import java.util.HashMap;
import java.util.Map;

public class Solution_291 {
    private boolean res = false;

    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> fwd = new HashMap<>();
        Map<String, Character> rwd = new HashMap<>();
        backtracking(fwd, rwd, pattern, 0, s, 0);
        return res;
    }

    private void backtracking(Map<Character, String> fwd, Map<String, Character> rwd, String pattern, int pIdx, String s, int pos) {
        if (fwd.size() != rwd.size()) {
            throw new RuntimeException("What's the fuck");
        }
        if (res) {
            return;
        }
        if (pIdx == pattern.length()) {
            if (pos == s.length()) {
                res = true;
            }
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String curr = s.substring(pos, i);
            Character c = pattern.charAt(pIdx);
            if (fwd.containsKey(c)) {
                if (!fwd.get(c).equals(curr)) {
                    continue;
                }
            }
            if (rwd.containsKey(curr)) {
                if (!rwd.get(curr).equals(c)) {
                    continue;
                }
            }
            boolean mapChange = false;
            if (!fwd.containsKey(c)) {
                mapChange = true;
                fwd.put(c, curr);
                rwd.put(curr, c);
            }
            backtracking(fwd, rwd, pattern, pIdx + 1, s, i);
            if (mapChange) {
                fwd.remove(c);
                rwd.remove(curr);
            }
        }
    }
}