package answers;

public class Solution_44 {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        if (slen == 0) {
            for (int i = 0; i < plen; i++) {
                char curr = p.charAt(i);
                if (curr != '*') {
                    return false;
                }
            }
            return true;
        }
        boolean[][] dp = new boolean[plen + 1][slen + 1];
        dp[0][0] = true;
        for (int m = 1; m <= plen; m++) {
            if (dp[m - 1][0] && p.charAt(m - 1) == '*') {
                dp[m][0] = true;
            }
        }

        for (int m = 1; m <= plen; m++) {
            if (p.charAt(m - 1) == '*') {
                int first = 0;
                for (; first <= slen; first++) {
                    if (dp[m - 1][first]) {
                        break;
                    }
                }
                for (int n = first; n <= slen; n++) {
                    dp[m][n] = true;
                }
                continue;
            }
            for (int n = 1; n <= slen; n++) {
                if (p.charAt(m - 1) == s.charAt(n - 1) && dp[m - 1][n - 1]) {
                    dp[m][n] = true;
                    continue;
                }
                if (p.charAt(m - 1) == '?' && dp[m - 1][n - 1]) {
                    dp[m][n] = true;
                    continue;
                }
            }
        }

        return dp[plen][slen];
    }
}
