package amazon;

import java.util.Arrays;

public class RectangleAreas {
    public int numOfRectanglesSmallerThan(int[] arr, int area) {
        Arrays.sort(arr);
        int n = arr.length;
        int j = n - 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (j >= 0 && arr[i] * arr[j] >= area) {
                j--;
            }
            res += (j + 1);
        }
        return res;
    }

    public int numOfRectanglesSmallerThanV2(int[] arr, int area) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (arr[i] * arr[m] < area) {
                    l = m;
                }
                else {
                    r = m - 1;
                }
            }
            res += (l + 1);
        }

        return res;
    }
}
