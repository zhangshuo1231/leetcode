package answers;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_105 {
    public TreeNode buildTreePre(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = extractIdxMap(inorder);
        return buildTreePreHelper(preorder, inorderIndexMap, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTreePost(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = extractIdxMap(inorder);
        return buildTreePostHelper(postorder, inorderIndexMap, inorder.length - 1, 0, postorder.length - 1);
    }

    /* PRE + IN */
    private TreeNode buildTreePreHelper(int[] preorder, Map<Integer, Integer> inorderIndexMap, int rootPreorderIdx, int in_st, int in_end) {
        if (rootPreorderIdx > preorder.length - 1 || in_st > in_end) {
            return null;
        }
        TreeNode curr = new TreeNode(preorder[rootPreorderIdx]);
        int rootInorder = inorderIndexMap.get(preorder[rootPreorderIdx]);
        curr.left = buildTreePreHelper(preorder, inorderIndexMap, rootPreorderIdx + 1, in_st, rootInorder - 1);
        curr.right = buildTreePreHelper(preorder, inorderIndexMap, rootPreorderIdx + (rootInorder - in_st) + 1, rootInorder + 1, in_end);
        return curr;
    }

    /* POST + IN */
    private TreeNode buildTreePostHelper(int[] postorder, Map<Integer, Integer> inorderIndexMap, int rootPostorderIdx, int in_st, int in_end) {
        if (rootPostorderIdx < 0 || in_st > in_end) {
            return null;
        }
        TreeNode curr = new TreeNode(postorder[rootPostorderIdx]);
        int rootInorder = inorderIndexMap.get(postorder[rootPostorderIdx]);
        curr.left = buildTreePostHelper(postorder, inorderIndexMap, rootPostorderIdx - (in_end - rootInorder) - 1, in_st, rootInorder - 1);
        curr.right = buildTreePostHelper(postorder, inorderIndexMap, rootPostorderIdx - 1, rootInorder + 1, in_end);
        return curr;
    }

    private Map<Integer, Integer> extractIdxMap(int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return inorderIndexMap;
    }
}