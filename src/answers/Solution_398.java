package answers;

import java.util.*;

public class Solution_398 {
    Map<Integer, List<Integer>> map;
    Random rand = new Random();
    public Solution_398(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            List list = map.get(nums[i]);
            list.add(i);
        }
    }
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int len = list.size();
        int indexInList = rand.nextInt(len);
        return list.get(indexInList);
    }
}
