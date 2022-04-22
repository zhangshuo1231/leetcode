package answers;

import java.util.PriorityQueue;

public class Solution_1648 {
    public int maxProfit(int[] inventory, int orders) {
        int mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : inventory) {
            pq.offer(num);
        }

        int cur = pq.poll();
        int count = 1; // # of balls with the biggest num
        long res = 0;
        while (orders > 0) {
            int next = pq.isEmpty() ? 0 : pq.peek();
            if ((cur - next) * count <= orders) {
                long num = ((long) (next + 1 + cur) * (cur - next) * count / 2) % mod;
                res = (res + num) % mod;
                orders -= (cur - next) * count;
            }
            else {
                next = cur - orders / count;
                long num = ((long) (next + 1 + cur) * (cur - next) * count / 2) % mod;
                res = (res + num) % mod;
                res = (res + (long) next * (orders % count)) % mod;
                orders = 0;
            }

            if (!pq.isEmpty()) {
                cur = pq.poll();
            }
            count++;
        }
        return (int) res;
    }
}
