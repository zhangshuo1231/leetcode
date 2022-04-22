package answers;

public class Solution_1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int len = s.length();
        if (k > len) {
            return 0;
        }
        int cnt = 0;
        int[] stats = new int[26];

        for (int i = 0; i < len; i++) {
            stats[s.charAt(i) - 'a']++;
            if (i > k - 1) {
                stats[s.charAt(i - k) - 'a']--;
            }
            if (isValid(stats, k)) {
                cnt++;
            }
        }

        return cnt;
    }

    private boolean isValid(int[] stats, int k) {
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (stats[i] > 1) {
                return false;
            }
            else if (stats[i] == 1) {
                cnt++;
            }
        }
        return cnt == k;
    }
}
