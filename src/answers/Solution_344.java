package answers;

public class Solution_344 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    private void swap(char[] s, int m, int n) {
        char x = s[m];
        s[m] = s[n];
        s[n] = x;
    }
}
