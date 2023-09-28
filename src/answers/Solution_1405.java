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
        char currChar = 'z';
        int currFreq = 0;

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
                if (currChar != max.c || currFreq < 2) {
                    sb.append(max.c);
                    if (currChar != max.c) {
                        currChar = max.c;
                        currFreq = 1;
                    }
                    else {
                        currFreq += 1;
                    }
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
                        currChar = second.c;
                        currFreq = 1;
                        second.cnt--;
                        queue.offer(second);
                        queue.offer(max);
                    }
                }
            }
        }
        return sb.toString();
    }
}
