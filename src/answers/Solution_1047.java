package answers;

public class Solution_1047 {
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int pilot = 0; pilot < n; pilot++) {
            res[i] = res[pilot];
            if (i > 0 && res[i - 1] == res[i]) {
                i -= 2;
            }
            i++;
        }
        return new String(res, 0, i);
    }
}
