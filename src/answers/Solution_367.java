package answers;

public class Solution_367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int i = 1;
        long total = 0;
        while (total < num) {
            total += i;
            i += 2;
        }
        return total == num;
    }
}
