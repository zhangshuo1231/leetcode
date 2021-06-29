package com.company;

public class SingleNumberFinder {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,2,2};
        System.out.println(singleNumber(nums, 4));
    }

    public static int singleNumber(int[] nums, int numDups) {
        if (nums.length == 1) return nums[0];
        int res = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & mask;
                sum %= numDups;
            }
            res = res | (sum << i);
        }
        return res;
    }
}
