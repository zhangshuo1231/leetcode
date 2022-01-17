package answers;

import model.TreeNode;

import java.util.*;

public class Solution_314 {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        bfs(root);
        List<Integer> sortedKey = new ArrayList(map.keySet());
        Collections.sort(sortedKey);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < sortedKey.size(); i++) {
            res.add(map.get(sortedKey.get(i)));
        }
        return res;
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.add(root);
        cols.add(0);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int col = cols.poll();
            visit(curr, col);
            if (curr.left != null) {
                queue.add(curr.left);
                cols.add(col - 1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                cols.add(col + 1);
            }
        }
    }

    private void visit(TreeNode node, int col) {
        List<Integer> list = map.getOrDefault(col, new ArrayList<>());
        list.add(node.val);
        map.put(col, list);
    }

    /*
    private void helper(TreeNode node, int col) {
        if (node == null) {
            return;
        }
        List<Integer> list = map.getOrDefault(col, new ArrayList<>());
        list.add(node.val);
        map.put(col, list);
        helper(node.left, col - 1);
        helper(node.right, col + 1);
    }
    */
}
