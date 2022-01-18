package answers;

import model.TreeNode;

import java.util.*;

public class Solution_987 {
    class TreeNodeWithRow {
        TreeNode node;
        int row;

        TreeNodeWithRow(TreeNode treeNode, int row) {
            this.node = treeNode;
            this.row = row;
        }
    }

    Map<Integer, PriorityQueue<TreeNodeWithRow>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0);
        for (Map.Entry<Integer, PriorityQueue<TreeNodeWithRow>> entry : map.entrySet()) {
            List<Integer> curr = new ArrayList<>();
            while (!entry.getValue().isEmpty()) {
                curr.add(entry.getValue().poll().node.val);
            }
            res.add(curr);
        }
        return res;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        PriorityQueue<TreeNodeWithRow> queue = map.getOrDefault(col, new PriorityQueue<>((a, b) -> a.row == b. row ? a.node.val - b.node.val : a.row - b.row));
        queue.offer(new TreeNodeWithRow(node, row));
        map.put(col, queue);
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1,col + 1);
    }
}
