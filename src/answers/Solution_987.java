package answers;

import model.TreeNode;

import java.util.*;

public class Solution_987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        List<Integer> cols = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        cols.add(0);
        int cx = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                int col = cols.get(cx++);

                List<int[]> list = map.getOrDefault(col, new ArrayList<>());
                list.add(new int[]{level, curr.val});
                map.put(col, list);

                if (curr.left != null) {
                    queue.offer(curr.left);
                    cols.add(col - 1);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    cols.add(col + 1);
                }
            }
            level++;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> pairs = entry.getValue();
            Collections.sort(pairs, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                else {
                    return a[1] - b[1];
                }
            });
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < pairs.size(); i++) {
                list.add(pairs.get(i)[1]);
            }
            res.add(list);
        }
        return res;
    }

    /*
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
    */
}
