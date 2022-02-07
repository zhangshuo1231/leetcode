package answers;

import java.util.*;

public class Solution_1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<int[]>> data = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<int[]> list = data.getOrDefault(keyName[i], new ArrayList<>());
            String[] times = keyTime[i].split(":");
            int hh = Integer.valueOf(times[0]);
            int mm = Integer.valueOf(times[1]);
            list.add(new int[]{hh, mm});
            data.put(keyName[i], list);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<int[]>> entry : data.entrySet()) {
            List<int[]> times = entry.getValue();
            Collections.sort(times, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            for (int i = 0; i + 2 < times.size(); i++) {
                if ((times.get(i)[0] == times.get(i + 2)[0])
                        || (times.get(i)[0] + 1 == times.get(i + 2)[0] && times.get(i)[1] >= times.get(i + 2)[1])) {
                    if (!res.contains(entry.getKey())) {
                        res.add(entry.getKey());
                    }
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
