package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    private void backtracking(TreeMap<Integer, Node> res, Node node) {
        if (node == null || res.containsKey(node.val))
            return;
        else {
            res.put(node.val, node);
        }
        for (Node curr : node.neighbors) {
            backtracking(res, curr);
        }
    }

    @Override
    public String toString() {
        TreeMap<Integer, Node> map = new TreeMap<>();
        backtracking(map, this);
        List<List<Integer>> list = new ArrayList<>();
        for (Node node : map.values()) {
            List<Integer> curr = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                curr.add(neighbor.val);
            }
            list.add(curr);
        }
        return list.toString();
    }
}
