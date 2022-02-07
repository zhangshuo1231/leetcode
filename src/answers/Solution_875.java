package answers;

public class Solution_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (time(piles, m) > h) {
                l = m + 1;
            }
            else {
                r = m;
            }
        }
        return r;
    }

    private int time(int[] piles, int s) {
        int res = 0;
        for (int i : piles) {
            res += (i % s == 0 ? i / s : i / s + 1);
        }
        return res;
    }
}
