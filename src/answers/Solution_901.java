package answers;

import java.util.Stack;

public class Solution_901 {
    private int currDay;
    private Stack<int[]> stack; // [price, day]

    public Solution_901() {
        this.currDay = 0;
        this.stack = new Stack<>();
        this.stack.push(new int[]{500001, 0});
    }

    public int next(int price) {
        currDay++;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            stack.push(new int[]{price, currDay});
            return 1;
        }
        else {
            int[] prev = stack.peek();
            int span = currDay - prev[1];
            stack.push(new int[]{price, currDay});
            return span;
        }
    }
}
