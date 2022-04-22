package com.company;

import java.util.Arrays;

public class QuickSort {

    /*
    quickSort函数（直接call数组，从 0 到 len - 1）概要：
        调用partition函数，把pivot放到正确位置并返回其idx
        【递归】idx左边的部分
        【递归】idx右边的部分
     */

    public static void main(String[] args) {
        int[] array = new int[]{3, 7, 2, 8, 11, 0, 9, 6};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int position = partition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                swap(array, i, pointer);
                pointer++;
            }
        }
        swap(array, pointer, high);
        return pointer;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }
}