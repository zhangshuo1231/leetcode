package answers;

import model.TreeNode;

public class Solution_1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root, p, q);
        return dist(lca, p, 0) + dist(lca, q, 0);
    }

    private int dist(TreeNode root, int target, int travel) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            return travel;
        }
        int restTravel = dist(root.left, target, travel + 1);
        if (restTravel == -1) {
            return dist(root.right, target, travel + 1);
        }
        return restTravel;
    }

    private TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
