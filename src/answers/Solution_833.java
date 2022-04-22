package answers;

import java.util.TreeMap;

public class Solution_833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        TreeMap<Integer, String[]> map = new TreeMap<>();
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            if (!s.substring(idx).startsWith(sources[i])) {
                continue;
            }
            else {
                map.put(idx, new String[]{sources[i], targets[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            if (!map.keySet().contains(idx)) {
                sb.append(s.charAt(idx++));
            }
            else {
                sb.append(map.get(idx)[1]);
                idx += map.get(idx)[0].length();
            }
        }
        return sb.toString();
    }
}
