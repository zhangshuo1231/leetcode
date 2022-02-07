package answers;

public class Solution_670 {
    public int maximumSwap(int num) {
        char[] original = String.valueOf(num).toCharArray();
        int[] digits = new int[10];
        int idx = 0;
        for (char c : original) {
            digits[c - '0'] = idx;
            idx++;
        }

        for (int i = 0; i < original.length; i++) {
            for (int d = 9; d > original[i] - '0'; d--) {
                if (digits[d] > i) {
                    swap(original, i, digits[d]);
                    return Integer.valueOf(String.valueOf(original));
                }
            }
        }

        return num;
    }

    private void swap(char[] original, int i, int j) {
        char tmp = original[j];
        original[j] = original[i];
        original[i] = tmp;
    }
}
