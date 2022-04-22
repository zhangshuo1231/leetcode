package answers;

public class Solution_1053 {
    public int[] prevPermOpt1(int[] arr) {
        int big = arr.length - 2, small = arr.length - 1;

        while (big >= 0 && arr[big] <= arr[big + 1]) {
            big--;
        }
        if (big < 0) {
            return arr;
        }

        while (arr[small] >= arr[big] || arr[small] == arr[small - 1]) {
            small--;
        }

        int tmp = arr[small];
        arr[small] = arr[big];
        arr[big] = tmp;
        return arr;
    }
}
