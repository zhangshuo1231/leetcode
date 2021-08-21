package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_7 {
    public int reverse(int x) {
        int s = x >= 0 ? 1 : -1;
        if (x < 0)
            x = (-1) * x;
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        int len = list.size();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int before = res;
            res = res * 10 + list.get(i);
            if ((res - list.get(i)) / 10 != before)
                return 0;
        }
        return res * s;
    }
}
