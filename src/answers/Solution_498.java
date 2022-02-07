package answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        List<Integer> res = new ArrayList<>();
        boolean asc = false;
        for (int i = 0; i < m; i++) {
            asc = !asc;
            List<Integer> curr = new ArrayList<>();
            int a = i, b = 0;
            while (a >= 0 && b < n) {
                curr.add(mat[a][b]);
                a--;
                b++;
            }
            if (!asc) {
                Collections.reverse(curr);
            }
            res.addAll(curr);
        }

        for (int j = 1; j < n; j++) {
            asc = !asc;
            List<Integer> curr = new ArrayList<>();
            int a = m - 1, b = j;
            while (a >= 0 && b < n) {
                curr.add(mat[a][b]);
                a--;
                b++;
            }
            if (!asc) {
                Collections.reverse(curr);
            }
            res.addAll(curr);
        }

        int[] result = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
