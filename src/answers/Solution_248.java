package answers;

public class Solution_248 {
    private int count = 0;
    private final char[][] pairs = new char[][] {{'0','0'},{'1', '1'},{'6','9'},{'8','8'},{'9','6'}};

    public int strobogrammaticInRange(String low, String high) {
        for (int len = low.length(); len <= high.length(); len++) {
            char[] temp = new char[len];
            backtracking(low, high, temp, 0, len - 1);
        }
        return count;
    }

    private void backtracking(String low, String high, char[] temp, int left, int right) {
        if (temp.length != 1 && temp[0] == '0') {
            return;
        }
        if (left > right) {
            String s = new String(temp);
            if ((s.length() == low.length() && s.compareTo(low) < 0) ||
                    (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            System.out.println(s);
            count++;
            return;
        }
        for (char[] p : pairs) {
            temp[left] = p[0];
            temp[right] = p[1];
            if (left == right && p[0] != p[1]) {
                continue;
            }
            backtracking(low, high, temp, left + 1, right - 1);
            temp[left] = 0;
            temp[right] = 0;
        }
    }
}
