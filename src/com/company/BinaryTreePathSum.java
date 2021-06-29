package com.company;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        backtrack(res, temp, root, sum);
        return res;
    }

    private static boolean[] path = new boolean[]{true, false};

    private static void backtrack(List<List<Integer>> res, List<Integer> temp, TreeNode curr, int sum) {
        if (curr.left == null && curr.right == null) { // leaf
            int total = 0;
            for (int element : temp) {
                total += element;
            }
            if (total == sum) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for(boolean direction : path) {
            TreeNode pointer;
            pointer = direction? curr.left : curr.right;
            if (pointer != null) {
                temp.add(pointer.val);
                backtrack(res, temp, pointer, sum);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
