package answers;

import java.util.Stack;

public class Solution_255 {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            System.out.println(path);
            path.push(p);
        }
        return true;
    }
}
