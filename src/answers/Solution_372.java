package answers;

import java.util.Stack;

public class Solution_372 {
    int base = 1337;
    public int superPow(int a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int n = b.length;
        for (int i = 0; i < n; i++) {
            stack.push(b[i]);
        }
        return hpPow(a, stack);
    }

    public int hpPow(int a, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 1;
        }
        int last = stack.pop();
        int part1 = myPow(a, last);
        int part2 = myPow(hpPow(a, stack), 10);
        return (part1 * part2) % base;
    }

    public int myPow(int a, int k) {
        int res = 1;
        a %= base;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }
}
