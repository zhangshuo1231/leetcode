package answers;

public class Solution_392 {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        else if (t.equals("")) {
            return false;
        }
        int sIdx = 0, tIdx = 0;
        while (sIdx < s.length()) {
            char c = s.charAt(sIdx);
            while (tIdx < t.length() && t.charAt(tIdx) != c) {
                tIdx++;
            }
            if (tIdx == t.length()) {
                return false;
            }
            if (t.charAt(tIdx) == c) {
                tIdx++;
            }
            sIdx++;
        }
        return true;
    }
}
