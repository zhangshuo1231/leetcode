package answers;

public class Solution_1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0, i = 0, m = nums1.length, n = nums2.length;
        for (int j = 0; j < n; j++) {
            while (i < m && nums1[i] > nums2[j]) {
                i++;
            }
            if (i == m) {
                break;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
