package answers;

import model.TreeNode;

import java.util.HashMap;

public class Solution_437 {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, targetSum, preSum);
    }

    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        currSum += root.val;

        // get the number of valid path, ended by the current node
        int res = preSum.getOrDefault(currSum - target, 0);

        // update the map with the current sum, so the map is good to be passed to the next recursion
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        // add the 3 parts discussed in 8. together
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);

        // restore the map, as the recursion goes from the bottom to the top
        preSum.put(currSum, preSum.get(currSum) - 1);

        return res;
    }
}