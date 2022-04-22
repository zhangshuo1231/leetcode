package meta;

public class MinimumDeleteParentheses {
    public String deleteParen(String s) {
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                break;
            }
        }
        s = s.substring(i);
        i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != '(') {
                break;
            }
        }
        s = s.substring(0, i + 1);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
               cnt++;
            }
            else if (c == ')') {
                if (cnt == 0) {
                    continue;
                }
                else {
                    cnt--;
                }
            }
            sb.append(c);
        }
        s = sb.toString();
        sb.setLength(0);
        i = s.length() - 1;
        cnt = 0;
        for (; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                cnt++;
            }
            else if (c == '(') {
                if (cnt == 0) {
                    continue;
                }
                else {
                    cnt--;
                }
            }
            sb.insert(0, c);
        }
        return sb.toString();
    }
}