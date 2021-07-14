package answers;

import java.util.*;

public class Solution_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        buildGraph(tickets, g);
        Stack<String> stack = new Stack<>();
        dfs(g, stack, "JFK");
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> g, Stack<String> stack, String from) {
        PriorityQueue<String> arrivals = g.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            String to = arrivals.poll();
            dfs(g, stack, to);
        }
        stack.push(from);
    }

    private void buildGraph(List<List<String>> tickets, Map<String, PriorityQueue<String>> g) {
        for (List<String> travel : tickets) {
            String from = travel.get(0);
            String to = travel.get(1);
            g.putIfAbsent(from, new PriorityQueue<>());
            g.get(from).add(to);
        }
    }
}
