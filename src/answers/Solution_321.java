package answers;

import java.util.Arrays;
import java.util.Stack;

public class Solution_321 {
    public static void main(String[] args) {
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;
        System.out.println(Arrays.toString(maxNumber(nums1, nums2, k)));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    public static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private static int[] maxArray(int[] nums, int len) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // 目前stack内的元素个数+数组中所剩元素个数仍大于目标长度，且stack不为空，且stack顶部元素小于当前入列数组元素
            while (stack.size() + nums.length - i > len && !stack.empty() && stack.peek() < nums[i]) {
                stack.pop();
            }
            // stack内元素个数仍不足目标长度 - 如果已经够长（且都比当前入列数组元素大），则没必要添加
            if (stack.size() < len) {
                stack.push(nums[i]);
            }
        }
        int[] result = new int[len];
        // 逆向构建返回数组
        for (int i = len - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
