package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intselector {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return new ArrayList<>(list);
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) {
        }
        else if(remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1); // allow same element: i; not allow same element: i + 1
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
