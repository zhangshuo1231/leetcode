package answers;

import java.util.Arrays;

public class Solusion_324 {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int n = nums.length;
        int left = (n + 1) / 2 - 1; // median index
        int right = n - 1; // largest value index
        for (int i = 0; i < nums.length; i++)
        {
            if( i % 2 == 0 ){
                nums[i] = copy[left];
                left--;
            } else {
                nums[i] = copy[right];
                right--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
