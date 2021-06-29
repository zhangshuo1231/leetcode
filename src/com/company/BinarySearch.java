package com.company;

import java.util.Arrays;

public class BinarySearch {
    public int[] binarySearch(int array[], int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return new int[]{mid, mid};
            }
            else {
                if (array[mid] > target) {
                    return binarySearch(array, left, mid - 1, target);
                }
                else {
                    return binarySearch(array, mid + 1, right, target);
                }
            }
        }
        return new int[]{right, left};
    }

    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {1, 2};
        int n = arr.length;
        int x = 3;
        int result[] = ob.binarySearch(arr, 0, n - 1, x);
        System.out.println(Arrays.toString(result));
    }
}
