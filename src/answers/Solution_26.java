package answers;

public class Solution_26 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, len = nums.length;
        while (j < len) {
            if (i == 0 || nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
