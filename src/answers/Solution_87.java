package answers;

public class Solution_87 {
//    public boolean isScramble(String s1, String s2) {
//        if (s1 == null || s2 == null || s1.length() != s2.length()) {
//            return false;
//        }
//        if (s1.length() == 1) {
//            return s1.equals(s2);
//        }
//        else if (s1.length() == 2) {
//            return s1.equals(s2) || (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0));
//        }
//
//        int n = s1.length();
//        for (int i = 0; i < n - 1; i++) {
//            String s1_left = s1.substring(0, i + 1);
//            String s1_right = s1.substring(i + 1);
//            String s2_left = s2.substring(0, i + 1);
//            String s2_right = s2.substring(i + 1);
//            String s2_rev_left = s2.substring(0, n - i - 1);
//            String s2_rev_right = s2.substring(n - i - 1);
//            if ((isScramble(s1_left, s2_left) && isScramble(s1_right, s2_right)) || (isScramble(s1_left, s2_rev_right) && isScramble(s1_right, s2_rev_left))) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        boolean[][][] F = new boolean[len][len][len + 1];
        for (int k = 1; k <= len; ++k)
            for (int i = 0; i + k <= len; ++i)
                for (int j = 0; j + k <= len; ++j)
                    if (k == 1)
                        F[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    else
                        for (int q = 1; q < k && !F[i][j][k]; ++q)
                        {
                            F[i][j][k] = (F[i][j][q] && F[i + q][j + q][k - q]) || (F[i][j + k - q][q] && F[i + q][j][k - q]);
                        }
        return F[0][0][len];
    }
}
