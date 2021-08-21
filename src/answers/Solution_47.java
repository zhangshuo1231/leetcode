package answers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(set, new ArrayList<>(), nums, new boolean[nums.length]);
        return new ArrayList<>(set);
    }

    private void backtrack(Set<List<Integer>> set, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            set.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if (used[i]) continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(set, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
