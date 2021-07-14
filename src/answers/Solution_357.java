package answers;

public class Solution_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        for (; n > 1; n--) {
            res += (permutation(10, n) - permutation(9, n - 1));
        }
        res += 10;
        return res;
    }

    private int permutation(int base, int num) {
        int res = 1;
        for (int x = 0; x < num; x++) {
            res *= (base - x);
        }
        return res;
    }
}