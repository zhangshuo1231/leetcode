package answers;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_337 {
    public int rob(TreeNode root) {
        return helper(root, new HashMap<>());
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> cache) {
        if (root == null) {
            cache.putIfAbsent(null, 0);
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        else {
            int robRoot = root.val;
            robRoot += (root.left == null? 0 : helper(root.left.left, cache) + helper(root.left.right, cache));
            robRoot += (root.right == null? 0 : helper(root.right.left, cache) + helper(root.right.right, cache));

            int noRobRoot = 0;
            noRobRoot += (helper(root.left, cache) + helper(root.right, cache));
            cache.putIfAbsent(root ,Math.max(robRoot, noRobRoot));
        }
        return cache.get(root);
    }
}
