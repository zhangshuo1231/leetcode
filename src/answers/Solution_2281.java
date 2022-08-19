package answers;

import java.util.Arrays;
import java.util.Stack;

// [1, 3, 1, 2]
public class Solution_2281 {
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = (preSum[i - 1] + strength[i - 1]);
        }

        System.out.println(Arrays.toString(preSum));
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int res = 0;
        for (int i = 0; i <= n; i++) {
            while (stack.peek() != -1 && (i == n || strength[stack.peek()] >= strength[i])) {
                int curr = stack.pop();
                int left = stack.peek();
                int right = i;
                System.out.print("curr = " + curr + ", left = " + left + ", right = " + right + " => ");

                int positive = 0, negative = 0, self = strength[curr];
                for (int ptr = right - 1; ptr > curr; ptr--) {
                    // positive += sum(0, ptr, preSum) * (curr - left);
                    positive += preSum[ptr] * (curr - left);
                }
                for (int ptr = left + 1; ptr <= curr; ptr++) {
                    // negative = sum(0, ptr, preSum) * (right - curr);
                    negative += preSum[ptr] * (right - curr);
                }
                int contribution = positive + self - negative;
                System.out.println("contribution = " + contribution);

                res += contribution * strength[curr];
            }
            stack.push(i);
        }
        return res;
    }

    private int sum(int i , int j, int[] preSum) {
        return (preSum[j + 1] - preSum[i]);
    }
}
