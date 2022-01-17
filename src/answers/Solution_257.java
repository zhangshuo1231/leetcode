package answers;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        if (root.left == null && root.right == null) {
            return Arrays.asList(new String[]{"" + root.val});
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        List<String> res = new ArrayList<>(left);
        res.addAll(right);

        for (int i = 0; i < res.size(); i++) {
            String curr = res.get(i);
            res.set(i, root.val + "->" + curr);
        }

        return res;
    }
}
