package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int x) { val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        System.out.println(root.toString());
        TreeNode res = deserialize(root.toString());
        System.out.println(root);
        // preOrder(root);
    }

    private static void preOrder(TreeNode root) {
        if (root == null)
            return;
        else {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static void leetbfs(TreeNode root, List<Integer> res) {
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

    public static TreeNode deserialize(String data) {
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
                if (treeNode != null ) {
                    if (!queue.isEmpty()) {
                        treeNode.left = queue.poll();
                        nextLayer.add(treeNode.left);
                    }
                    if (!queue.isEmpty()) {
                        treeNode.right = queue.poll();
                        nextLayer.add(treeNode.right);
                    }
                }
                else
                    continue;
            }
            currLayer.clear();
            currLayer.addAll(nextLayer);
        }
        return root;
    }

    private static List<Integer> trim(List<Integer> list) {
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

    @Override
    public String toString() {
        List<Integer> res = new ArrayList<>();
        if (this != null) {
            leetbfs(this, res);
        }
        else {
            res.add(null);
        }
        res = trim(res);
        Integer[] array = new Integer[res.size()];
        res.toArray(array);
        return Arrays.toString(array);
    }
}
