package answers;

public class Solution_80 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (j < 2 || nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
