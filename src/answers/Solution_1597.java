package answers;

import model.TreeNode;

import java.util.*;

class Node {
     char val;
     Node left;
     Node right;
     Node() {this.val = ' ';}
     Node(char val) { this.val = val; }
     Node(char val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     private void leetbfs(Node root, List<Character> res) {
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()) {
             Node temp = queue.poll();
             if (temp == null)
                 res.add(null);
             else {
                 res.add(temp.val);
                 queue.add(temp.left);
                 queue.add(temp.right);
             }
         }
     }

    private List<Character> trim(List<Character> list) {
        List<Character> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (Character integer : list) {
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
        List<Character> res = new ArrayList<>();
        if (this != null) {
            leetbfs(this, res);
        }
        else {
            res.add(null);
        }
        res = trim(res);
        Character[] array = new Character[res.size()];
        res.toArray(array);
        return Arrays.toString(array);
    }
 }

public class Solution_1597 {
    public Node expTree(String s) {
        s = '(' + s + ')';
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            System.out.println(stack);

            if (!Character.isDigit(c) && c != '(') { //非数字，非左括号
                Node right = stack.pop();
                if (c == '*' || c == '/') { //乘除
                    if (stack.peek().val == '*' || stack.peek().val == '/') {
                        Node ops = stack.pop();
                        Node left = stack.pop();
                        ops.left = left;
                        ops.right = right;
                        right = ops;
                    }
                }
                else { //加减，右括号 - 计算当前所有
                    while (stack.peek().val != '(') {
                        Node ops = stack.pop();
                        Node left = stack.pop();
                        ops.left = left;
                        ops.right = right;
                        right = ops;
                    }
                    if (c == ')') {
                        stack.pop();
                    }
                }
                stack.push(right);
            }

            if (c != ')') { //除了右括号
                stack.push(new Node(c));
            }
        }
        return stack.pop();
    }
}
