package answers;

import java.util.Stack;

public class Solution_32 {
    public int longestValidParentheses(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    }
                    else {
                        stack.push(i);
                    }
                }
                else {
                    stack.push(i);
                }
            }
        }
        if (stack.isEmpty()) {
            return n;
        }
        else {
            int last = n, next;
            while (!stack.isEmpty()) {
                next = stack.pop();
                longest = Math.max(longest, last - next - 1);
                last = next;
            }
            longest = Math.max(longest, last);
        }
        return longest;
    }

    public int _longestValidParentheses(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.empty()) {
                    if (s.charAt(stack.peek()) == '(')
                        stack.pop();
                    else
                        stack.push(i);
                }
                else
                    stack.push(i);
            }
        }
        if (stack.empty())
            return n;
        else {
            int last = n, next;
            while (!stack.empty()) {
                next = stack.pop();
                longest = Math.max(longest, last - next -1);
                last = next;
            }
            longest = Math.max(longest, last);
        }
        return longest;
    }
}
