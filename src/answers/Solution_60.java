package answers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_60 {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        StringBuilder strBuilder = new StringBuilder();
        k = k - 1;
        for (; n > 0; n--) {
            fact /= n;
            strBuilder.append(list.remove(k / fact));
            k %= fact;
        }
        return strBuilder.toString();
    }
}
