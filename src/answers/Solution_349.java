package answers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Integer[] numA = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        Integer[] numB = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
        Set numOne = new HashSet(Arrays.asList(numA));
        Set numTwo = new HashSet(Arrays.asList(numB));
        Set<Integer> inter = new HashSet(numOne);
        inter.retainAll(numTwo);
        int[] res = new int[inter.size()];
        int idx = 0;
        for (Integer i : inter) {
            res[idx++] = i;
        }
        return res;
    }
}
