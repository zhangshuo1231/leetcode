package com.company;

import java.util.Arrays;

public class NumArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 0));
        numArray.update(0,1);
        System.out.println(numArray.sumRange(0, 0));
    }

    private int[] nums;

    public NumArray(int[] nums) {
        if (!(nums == null || nums.length == 0)) {
            this.nums = new int[nums.length];
            this.nums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                this.nums[i] = this.nums[i - 1] + nums[i];
            }
        }
    }

    public void update(int i, int val) {
        int base;
        if (i > 0) {
            base = this.nums[i] - this.nums[i - 1];
        }
        else {
            base = this.nums[0];
        }
        int gap = val - base;
        for(int j = i; j < this.nums.length; j++) {
            this.nums[j] = this.nums[j] + gap;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return this.nums[j];
        return this.nums[j] - this.nums[i-1];
    }
}
