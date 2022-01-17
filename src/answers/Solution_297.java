package answers;

import model.TreeNode;

import java.util.*;

public class Solution_297 {
    public String serialize(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            leetbfs(root, res);
        }
        else {
            return null;
        }
        res = trim(res);
        Integer[] array = new Integer[res.size()];
        res.toArray(array);
        return Arrays.toString(array);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        List<String> list = Arrays.asList(data.substring(1, data.length() - 1).split(","));
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String curr = list.get(i).trim();
            if (!curr.equals("null"))
                queue.add(new TreeNode(Integer.valueOf(curr)));
            else
                queue.add(null);
        }
        TreeNode root = queue.poll();
        List<TreeNode> currLayer = new ArrayList<>();
        currLayer.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nextLayer = new ArrayList<>();
            for (TreeNode treeNode : currLayer) {
                if (treeNode != null) {
                    if (!queue.isEmpty()) {
                        treeNode.left = queue.poll();
                        nextLayer.add(treeNode.left);
                    }
                    if (!queue.isEmpty()) {
                        treeNode.right = queue.poll();
                        nextLayer.add(treeNode.right);
                    }
                }
                else {
                    continue;
                }
            }
            currLayer.clear();
            currLayer.addAll(nextLayer);
        }
        return root;
    }

    private void leetbfs(TreeNode root, List<Integer> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null)
                res.add(null);
            else {
                res.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
    }

    private List<Integer> trim(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer integer : list) {
            stack.push(integer);
        }
        while(stack.peek() == null) {
            stack.pop();
        }
        res.addAll(stack);
        return res;
    }
}
