package answers;

public class Solution_390 {
    public int lastRemaining(int n) {
        boolean moveFromLeft = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (moveFromLeft || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            moveFromLeft = !moveFromLeft;
        }
        return head;
    }
}
