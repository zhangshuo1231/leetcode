package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_254 {
    public List<List<Integer>> getFactors(int n) {
        if (n == 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> temp, int n, int start) {
        if (n == 1 && temp.size() > 1) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                temp.add(i);
                helper(result, temp, n / i, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
