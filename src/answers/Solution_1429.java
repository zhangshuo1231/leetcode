package answers;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Solution_1429 {
    LinkedHashSet<Integer> single = new LinkedHashSet<>();
    LinkedHashSet<Integer> multiple = new LinkedHashSet<>();

    public Solution_1429(int[] nums) {
        for (int i : nums) {
            if (multiple.contains(i)) {
                continue;
            }
            else {
                if (single.contains(i)) {
                    single.remove(i);
                    multiple.add(i);
                }
                else {
                    single.add(i);
                }
            }
        }
    }

    public int showFirstUnique() {
        if (single.isEmpty()) {
            return -1;
        }
        Iterator<Integer> itor = single.iterator();
        return itor.next();
    }

    public void add(int i) {
        if (multiple.contains(i)) {
            return;
        }
        else {
            if (single.contains(i)) {
                single.remove(i);
                multiple.add(i);
            }
            else {
                single.add(i);
            }
        }
    }
}
