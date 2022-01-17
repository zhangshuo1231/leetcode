package answers;

import model.TreeNode;

public class Solution_298 {
    int longest = 1;

    private int helper(TreeNode root) {
        int curr = 1;
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (root.left != null && root.val + 1 == root.left.val) {
            curr = Math.max(curr, left + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            curr = Math.max(curr, right + 1);
        }
        longest = Math.max(longest, curr);
        return curr;
    }

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }
}