package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSquare {

    public int longest(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 1;
        for (int i : arr) {
            int curr = 0;
            while (set.contains(i)) {
                curr++;
                set.remove(i);
                i *= i;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
