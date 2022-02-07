package answers;

import model.TreeNode;

public class Solution_865 {
    int deepestLevel = 0;
    TreeNode res = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int level) {
        if (root == null) {
            return level;
        }

        int leftLevel = dfs(root.left, level + 1);
        int rightLevel = dfs(root.right, level + 1);

        int curLevel = Math.max(leftLevel, rightLevel);
        deepestLevel = Math.max(deepestLevel, curLevel);

        if (leftLevel == deepestLevel && rightLevel == deepestLevel) {
            res = root;
        }
        System.out.println("Current Node: " + root.val + ", curLevel = " + curLevel + ", deepestLevel = " + deepestLevel + ", res = " + res.val);
        return curLevel;
    }
}
