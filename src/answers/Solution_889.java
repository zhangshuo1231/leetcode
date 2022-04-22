package answers;

import model.TreeNode;

public class Solution_889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, 0, preorder.length - 1, postorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int leftSubRootInPre = preStart + 1;
        int leftSubRootInPost = findLeftRootInPost(pre[leftSubRootInPre], post, postStart, postEnd);
        int leftSubEndInPre = leftSubRootInPre + (leftSubRootInPost - postStart);

        TreeNode leftSubRoot = helper(pre, leftSubRootInPre, leftSubEndInPre, post, postStart, leftSubRootInPost);
        TreeNode rightSubRoot = helper(pre, leftSubEndInPre + 1, preEnd, post, leftSubRootInPost + 1, postEnd - 1);

        root.left = leftSubRoot;
        root.right = rightSubRoot;
        return root;
    }

    private int findLeftRootInPost(int leftRootVal, int[] post, int postStart, int postEnd) {
        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == leftRootVal) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}
