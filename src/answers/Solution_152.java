package answers;

public class Solution_152 {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i] * min;
            int b = nums[i] * max;
            int c = nums[i];
            min = Math.min(Math.min(a, b), c);
            max = Math.max(Math.max(a, b), c);
            res = Math.max(res, max);
        }
        return res;
    }
}
