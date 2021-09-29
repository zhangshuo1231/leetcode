package answers;

import model.TreeNode;

public class Solution_112 {
    boolean res = false;
    boolean[] goLeft = new boolean[]{true, false};

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        backtrack(root.val, root, targetSum);
        return res;
    }

    private void backtrack(int tempSum, TreeNode curr, int target) {
        if (curr.left == null && curr.right == null && tempSum == target) {
            res = true;
        }

        for (boolean left : goLeft) {
            if (left && curr.left != null) {
                tempSum += curr.left.val;
                backtrack(tempSum, curr.left, target);
                tempSum -= curr.left.val;
            }
            if (!left && curr.right != null) {
                tempSum += curr.right.val;
                backtrack(tempSum, curr.right, target);
                tempSum -= curr.right.val;
            }
        }
    }
}
