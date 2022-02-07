package answers;

import model.TreeNode;

import java.util.Stack;

public class Solution_536 {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = null, curNode = null;
        int sign = 1, si = 0;

        while (si < s.length()) {
            if (s.charAt(si) == ')') { // 关门-pop最后一个node并且挂在peek的node下面
                curNode = stack.pop();
                parent = stack.peek();
                if (parent.left != null) {
                    parent.right = curNode;
                } else {
                    parent.left = curNode;
                }
                si++;
            } else if (s.charAt(si) == '-') { // 负号直接赋值sign
                sign = -1;
                si++;
            } else if (s.charAt(si) == '(') { // 开门过
                si++;
            } else { // 数字读出并且包装成node入栈
                int num = 0;
                while (si < s.length() && s.charAt(si) >= '0' && s.charAt(si) <= '9') {
                    num = num * 10 + s.charAt(si) - '0';
                    si++;
                }
                num *= sign;
                sign = 1;
                stack.push(new TreeNode(num));
            }
        }

        if (!stack.isEmpty()) {
            return stack.peek();
        }

        return parent;
    }
}
