package com.company;

import java.util.Arrays;

public class StandardBinarySearch {
    public static int[] search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            System.out.println(Arrays.toString(new int[]{start, end}));
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return new int[]{mid, mid};
            }
            else {
                if (nums[mid] > target) {
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args){
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 7, 8, 10, 11, 12};
        int target = 6;
        int[] idx = search(nums, target);
        System.out.println(Arrays.toString(idx));
    }
}
