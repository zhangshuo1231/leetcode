package answers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution_1405 {
    class unit {
        char c;
        int cnt;
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<unit> queue = new PriorityQueue<>((i, j) -> j.cnt - i.cnt);

        Map<Character, Integer> curr = new HashMap<>();
        curr.put('a', 0);
        curr.put('b', 0);
        curr.put('c', 0);

        StringBuilder sb = new StringBuilder();

        unit au = new unit();
        au.c = 'a';
        au.cnt = a;

        unit bu = new unit();
        bu.c = 'b';
        bu.cnt = b;

        unit cu = new unit();
        cu.c = 'c';
        cu.cnt = c;

        queue.offer(au);
        queue.offer(bu);
        queue.offer(cu);

        while (true) {
            unit max = queue.poll();
            if (max.cnt == 0) {
                break;
            }
            else {
                if (curr.get(max.c) != 2) {
                    sb.append(max.c);
                    curr.put(max.c, curr.get(max.c) + 1);
                    cleanExcept(curr, max.c);
                    max.cnt--;
                    queue.offer(max);
                }
                else {
                    unit second = queue.poll();
                    if (second.cnt == 0) {
                        break;
                    }
                    else {
                        sb.append(second.c);
                        curr.put(second.c, 1);
                        cleanExcept(curr, second.c);
                        second.cnt--;
                        queue.offer(second);
                        queue.offer(max);
                    }
                }
            }
        }
        return sb.toString();
    }

    private void cleanExcept(Map<Character, Integer> curr, char c) {
        for (char key : curr.keySet()) {
            if (key != c) {
                curr.put(key, 0);
            }
        }
    }
}
