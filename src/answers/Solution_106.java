package answers;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, inorderIndexMap, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, Map<Integer, Integer> inorderIndexMap, int rootIdx, int in_st, int in_end) {
        if (rootIdx < 0 || in_st > in_end) {
            return null;
        }
        TreeNode curr = new TreeNode(postorder[rootIdx]);
        int rootInorder = inorderIndexMap.get(postorder[rootIdx]);
        curr.left = buildTreeHelper(postorder, inorderIndexMap, rootIdx - (in_end - rootInorder) - 1, in_st, rootInorder - 1);
        curr.right = buildTreeHelper(postorder, inorderIndexMap, rootIdx - 1, rootInorder + 1, in_end);
        return curr;
    }
}
