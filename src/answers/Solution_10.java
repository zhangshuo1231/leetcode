package answers;

public class Solution_10 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) { // 初始条件是s匹配完了所有的p,整个思路是用s匹配p
            return s.isEmpty();
        }

        boolean first_match = (!s.isEmpty() && ((p.charAt(0) == s.charAt(0)) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
