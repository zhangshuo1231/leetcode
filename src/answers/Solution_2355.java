package answers;

import java.util.Arrays;
import java.util.Stack;

public class Solution_2355 {
    /*
    public long maximumBooks(int[] books) {
        int len = books.length;
        long[] dp = new long[len];
        Stack<Integer> stack = new Stack<>();
        long max = 0;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - (i - stack.peek())) {
                stack.pop();
            }
            long curr;
            if (stack.isEmpty()) {
                curr = 0;
            }
            else {
                curr = dp[stack.peek()];
            }
            curr += (getSum(books[i]) - getSum(books[i] - (i - (stack.isEmpty() ? -1 : stack.peek()))));

            dp[i] = curr;
            max = Math.max(max, dp[i]);
            stack.push(i);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
    private long getSum(int n) {
        if (n < 0) {
            return 0;
        }
        return (long) ((long) n * (long) (n + 1)) / 2;
    }
    */

    public long maximumBooks(int[] books) {
        int len = books.length;
        long[] dp = new long[len];
        Stack<Integer> stack = new Stack<>();
        long max = 0;

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - (i - stack.peek())) {
                stack.pop();
            }
            long curr;
            if (stack.isEmpty()) {
                curr = 0;
            }
            else {
                curr = dp[stack.peek()];
            }

            if (stack.isEmpty()) {
                curr += backSum(books[i], i + 1);
            }
            else {
                curr += backSum(books[i], i - stack.peek());
            }

            dp[i] = curr;
            max = Math.max(max, dp[i]);
            stack.push(i);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    private long backSum(int n, int cnt) {
        if (n < 0) throw new RuntimeException();
        else if (n == 0) return 0;
        long end = (long) n;
        long num = (long) cnt;
        if (cnt > n) {
            return (1 + (long)n) * (long)n / 2;
        }
        return ((end - num + 1) + end) * num / 2;
    }
}
