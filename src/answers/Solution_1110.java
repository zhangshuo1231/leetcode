package answers;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1110 {
    private List<TreeNode> res = new ArrayList<>();
    private List<Integer> td = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) {
            td.add(i);
        }
        process(root, null, root);
        return res;
    }

    private void process(TreeNode root, TreeNode parent, TreeNode curr) {
        if (curr == null) {
            if (root != null) {
                add(root);
            }
            return;
        }

        if (td.contains(curr.val)) {
            add(root);
            process(curr.left, null, curr.left);
            process(curr.right, null, curr.right);
            if (parent != null) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        else {
            process(root, curr, curr.left);
            process(root, curr, curr.right);
        }
    }

    private void add(TreeNode node) {
        if (!res.contains(node)) {
            res.add(node);
        }
    }
}
