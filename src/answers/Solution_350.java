package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            while (i < nums1.length && j < nums2.length && nums1[i] != nums2[j]) {
                if (nums1[i] > nums2[j])
                    j++;
                else
                    i++;
            }
            if (i < nums1.length && j < nums2.length) {
                int curr = nums1[i];
                int count1 = 0, count2 = 0;
                while (i < nums1.length && nums1[i] == curr) {
                    i++;
                    count1++;
                }
                while (j < nums2.length && nums2[j] == curr) {
                    j++;
                    count2++;
                }
                for (int count = 0; count < Math.min(count1, count2); count++) {
                    list.add(curr);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int x = 0; x < list.size(); x++) {
            result[x] = list.get(x);
        }
        return result;
    }
}
