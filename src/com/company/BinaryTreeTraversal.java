package com.company;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        List<Integer> res = new ArrayList<>();
        leetbfs(root, res);
        System.out.println(trim(res));
    }

    // DFS:

    private static void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    private static void preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    private static void postorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
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

    // BFS:
    private static void queuebfs(TreeNode root, List<Integer> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    // BFS:
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
}
