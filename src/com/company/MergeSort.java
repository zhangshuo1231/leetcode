package com.company;

import java.util.Arrays;

public class MergeSort {

    /*
    mergeSort函数（直接call数组，从 0 到 len - 1）概要：
        随便找个中点
        【递归】mergeSort左边（含中点），【递归】mergeSort右边（不含中点）
        merge
     */

    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 2, 8, 11, 0, 9, 6};
        new MergeSort().mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;

        int[] part1 = new int[len1];
        int[] part2 = new int[len2];

        System.arraycopy(arr, l, part1, 0, len1);
        System.arraycopy(arr, m + 1, part2, 0, len2);

        int i = 0, j = 0;
        int k = l;
        while (i < len1 && j < len2) {
            if (part1[i] <= part2[j]) {
                arr[k] = part1[i];
                i++;
            }
            else {
                arr[k] = part2[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k++] = part1[i++];
        }

        while (j < len2) {
            arr[k++] = part2[j++];
        }
    }
}
