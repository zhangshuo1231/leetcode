package answers;

import java.util.*;

public class Solution_Meta {
    public int[] sort(int[] arr) {
        int n = arr.length;
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        boolean isAsc = arr[1] >= arr[0];
        curr.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1] && isAsc) {
                curr.add(arr[i]);
            }
            else if (arr[i] < arr[i - 1] && !isAsc) {
                curr.add(arr[i]);
            }
            else {
                if (isAsc) {
                    lists.add((List<Integer>)curr.clone());
                }
                else {
                    Collections.reverse(curr);
                    lists.add((List<Integer>)curr.clone());
                }
                isAsc = !isAsc;
                curr.clear();
                curr.add(arr[i]);
            }
        }
        if (!isAsc) {
            Collections.reverse(curr);
        }
        lists.add(curr);

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        List<Integer> res = new ArrayList<>();
        for (List<Integer> list : lists) {
            queue.offer(list);
        }
        while (!queue.isEmpty()) {
            List<Integer> head = queue.poll();
            res.add(head.remove(0));
            if (!head.isEmpty()) {
                queue.offer(head);
            }
        }

        int[] result = new int[res.size()];
        int idx = 0;
        for (int i : res) {
            result[idx++] = i;
        }
        return result;
    }
}