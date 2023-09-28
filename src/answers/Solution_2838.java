package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_2838 {
    class Monster {
        int blood;
        int coin;

        Monster(int blood, int coin) {
            this.blood = blood;
            this.coin = coin;
        }
    }

    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int n = heroes.length;
        int m = monsters.length;

        List<Monster> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new Monster(monsters[i], coins[i]));
        }

        Collections.sort(list, (a, b) -> {
            return Integer.compare(a.blood, b.blood);
        });

        long[] preSum = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            preSum[i] = preSum[i - 1] + list.get(i - 1).coin;
        }

        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            int l = -1, r = m - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (list.get(mid).blood <= heroes[i]) {
                    l = mid;
                }
                else {
                    r = mid - 1;
                }
            }
            res[i] = preSum[r + 1];
        }

        return res;
    }
}
