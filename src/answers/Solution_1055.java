package answers;

public class Solution_1055 {
    public int shortestWay(String source, String target) {
        int i = 0, ans = 0;
        while (i != target.length()) {
            int next = scan(source, target, i);
            if (next == i) {
                return -1;
            }
            ans++;
            i = next;
        }
        return ans;
    }

    private int scan(String source, String target, int i) {
        for (char charSrc : source.toCharArray()) {
            if (i != target.length()) {
                char charTar = target.charAt(i);
                if (charTar == charSrc) {
                    i++;
                }
            }
        }
        return i;
    }
}
