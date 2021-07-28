package answers;

public class Solution_374 {
    private static int pick = 314159;

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    private static int guess(int num) {
        if (pick < num) {
            return -1;
        }
        else if (pick > num) {
            return 1;
        }
        return 0;
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        if (guess(left) == 0) {
            return left;
        }
        if (guess(right) == 0) {
            return right;
        }
        int ans;
        while ((ans = guess(n)) != 0) {
            if (ans > 0) {
                left = n;
                n += (right - n) / 2;
            }
            else {
                right = n;
                n -= (n - left) / 2;
            }
        }
        return n;
    }
}
