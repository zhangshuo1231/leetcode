package answers;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_919 {
    TreeNode root;
    Queue<TreeNode> queue;

    public Solution_919(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        tmpQueue.offer(root);

        while (!tmpQueue.isEmpty()) {
            TreeNode node = tmpQueue.poll();
            if (node.left == null || node.right == null ) {
                queue.offer(node);
            }
            if (node.left != null) {
                tmpQueue.offer(node.left);
            }
            if (node.right != null) {
                tmpQueue.offer(node.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode node = queue.peek();
        TreeNode ins = new TreeNode(val);
        queue.offer(ins);
        if (node.left == null) {
            node.left = ins;
        }
        else {
            node.right = ins;
            queue.poll();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
