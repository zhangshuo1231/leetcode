package answers;

import java.util.HashMap;
import java.util.Map;

public class Solution_691 {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (char c : stickers[i].toCharArray()) {
                mp[i][c - 'a']++;
            }
        }
        memo.put("", 0);
        return helper(memo, mp, target);
    }

    private int helper(Map<String, Integer> memo, int[][] stickersLetterMap, String target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int ans = Integer.MAX_VALUE, n = stickersLetterMap.length;
        int[] targetLetterArray = new int[26];
        for (char c : target.toCharArray()) {
            targetLetterArray[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (stickersLetterMap[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetLetterArray[j] > 0) {
                    int numCurrLetterLeft = Math.max(0, targetLetterArray[j] - stickersLetterMap[i][j]);
                    for (int k = 0; k < numCurrLetterLeft; k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            String s = sb.toString();
            int tmp = helper(memo, stickersLetterMap, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }

        memo.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return memo.get(target);
    }
}
