package answers;

public class Solution_344 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            swap(s, i, j);
        }
    }

    private void swap(char[] s, int m, int n) {
        char x = s[m];
        s[m] = s[n];
        s[n] = x;
    }
}
