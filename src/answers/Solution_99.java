package answers;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_99 {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        long[] swapped = findTwoSwapped(nums);
        recover(root, (int) swapped[0], (int) swapped[1]);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private long[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        long x = Integer.MAX_VALUE + 1, y = Integer.MAX_VALUE + 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == Integer.MAX_VALUE + 1) {
                    x = nums.get(i);
                }
                else {
                    break;
                }
            }
        }
        return new long[]{x, y};
    }

    private void recover(TreeNode r, int x, int y) {
        if (r == null) {
            return;
        }
        else {
            if (r.val == x || r.val == y) {
                r.val = r.val == x ? y : x;
            }
            recover(r.left, x, y);
            recover(r.right, x, y);
        }
    }
}
