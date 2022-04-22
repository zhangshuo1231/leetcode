package answers;

import java.util.Arrays;

public class ElementSwapping {
    int swap(int[] arr, int left, int right, int k) {
        int toMove = right;
        while (k > 0 && toMove >= left + 1) {
            int tmp = arr[toMove];
            arr[toMove] = arr[toMove - 1];
            arr[toMove - 1] = tmp;
            k--;
            toMove--;
        }
        return k;
    }

    int findMinInRange(int[] arr, int start, int end) {
        int res = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[res]) {
                res = i;
            }
        }
        return res;
    }

    int[] findMinArray(int[] arr, int k) {
        // Write your code here
        int start = 0;
        while (start < arr.length && k > 0) {
            int reach = Math.min(start + k, arr.length - 1);
            int minIdxInRange = findMinInRange(arr, start, reach);
            if (minIdxInRange > start) {
                k = swap(arr, start, minIdxInRange, k);
            }
            start++;
        }
        return arr;
    }

    public static void main(String[] args) {
        ElementSwapping elementSwapping = new ElementSwapping();
        System.out.println(Arrays.toString(elementSwapping.findMinArray(new int[]{5, 3, 1}, 2)));
    }
}
