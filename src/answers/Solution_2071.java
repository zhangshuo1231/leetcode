package answers;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class Solution_2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int lo = 0, hi = Math.min(m, n);

        while(lo < hi) {
            int mid = hi - ((hi - lo)>>1);
            int count = 0;
            boolean flag = true;
            TreeMap<Integer, Integer> strengthOfWorkers = new TreeMap<>();
            for (int w: workers)
                strengthOfWorkers.put(w, strengthOfWorkers.getOrDefault(w, 0) + 1);
            for (int i = mid - 1; i >= 0; --i) {
                // Case 1: Trying to assign to a worker without the pill
                int k1 = strengthOfWorkers.lastKey();
                if (tasks[i] <= k1) {
                    strengthOfWorkers.put(k1, strengthOfWorkers.get(k1) - 1);
                    strengthOfWorkers.remove(k1, 0);
                } else {
                    // Case 2: Trying to assign to a worker with the pill
                    Integer k2 = strengthOfWorkers.ceilingKey(tasks[i] - strength);
                    if (k2 != null) {
                        ++count;
                        strengthOfWorkers.put(k2, strengthOfWorkers.get(k2) - 1);
                        strengthOfWorkers.remove(k2, 0);
                    } else {
                        // Case 3: Impossible to assign mid tasks
                        flag = false;
                        break;
                    }
                }
                if(count > pills) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                lo = mid;
            else
                hi = mid - 1;
        }
        return lo;
    }
}
