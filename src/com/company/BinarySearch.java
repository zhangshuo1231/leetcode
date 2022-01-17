package com.company;

import java.util.Arrays;

public class BinarySearch {
    public int binarySearch(int array[], int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            else {
                if (array[mid] > target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {1, 2, 3, 5, 7, 8, 9};
        int n = arr.length;
        int x = 4;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        System.out.println(result);
    }
}
