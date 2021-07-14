package answers;

public class Solution_334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) {
                small = n; // update small if n is smaller than both
            }
            else if (n <= middle) {
                middle = n; // update middle only if greater than small but smaller than middle
            }
            else {
                return true; // return if you find a number bigger than both
            }
            System.out.println("small: " + small + ", middle: " + middle);
        }
        return false;
    }
}
