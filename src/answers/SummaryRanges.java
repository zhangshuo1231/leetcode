package answers;

import java.util.*;

public class SummaryRanges {
    TreeMap<Integer, int[]> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        System.out.println();
        if(map.containsKey(val))
            return;
        Integer lowerKey = map.lowerKey(val);
        Integer higherKey = map.higherKey(val);
        if(lowerKey != null && higherKey != null && val == map.get(lowerKey)[1]+1 && val == map.get(higherKey)[0] - 1) { // 正好连上了
            map.get(lowerKey)[1] = map.get(higherKey)[1];
            map.remove(higherKey);
        } else if (lowerKey != null && val <= map.get(lowerKey)[1] + 1) { // 被下面的覆盖了 或者 刚好延伸一下下面的上限
            map.get(lowerKey)[1] = Math.max(val,map.get(lowerKey)[1]);
        } else if (higherKey != null && val == map.get(higherKey)[0] - 1) { // 刚好延伸一下上面的下限
            map.put(val,new int[]{val, map.get(higherKey)[1]});
            map.remove(higherKey);
        } else {
            map.put(val,new int[]{val,val}); // 单个的
        }
        System.out.println("Add " + val + "!!!");
        printData();
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for(int[] a:map.values()){
            res[i++] = a;
        }
        System.out.println("GET: " + Arrays.deepToString(res));
        return res;
    }

    private void printData() {
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + Arrays.toString(entry.getValue()));
        }
    }
}
