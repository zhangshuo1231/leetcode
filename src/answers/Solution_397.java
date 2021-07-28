package answers;

import java.util.Arrays;

public class Solution_397 {
    public int integerReplacement(int n) {
        int steps = 0;
        System.out.println(Integer.toBinaryString(n));
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                --n;
            } else {
                ++n;
            }
            ++steps;
            System.out.println(Integer.toBinaryString(n));
        }
        return steps;
    }
}
