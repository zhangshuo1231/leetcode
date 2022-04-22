package answers;

import java.util.Stack;

public class Solution_2019 {
    public int calculate(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        char prevOperator = '+';
        int currNum = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (Character.isDigit(ch)) {
                currNum = ch - '0';
            }
            if (i >= s.length() || ch == '+' || ch == '*') {
                if (prevOperator == '+') {
                    stack.push(currNum);
                }
                else {
                    stack.push(stack.pop() * currNum);
                }
                prevOperator = ch;
                currNum = 0;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
