package answers;

import java.util.Stack;

public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] circle = new int[nums.length * 2];
        System.arraycopy(nums, 0, circle, 0, nums.length);
        System.arraycopy(nums, 0, circle, nums.length, nums.length);
        Stack<Integer> stack = new Stack<>();
        int[] targets = new int[circle.length];
        for (int i = circle.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && circle[i] >= stack.peek()) {
                stack.pop();
            }
            targets[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(circle[i]);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = targets[i];
        }
        return result;
    }
}
