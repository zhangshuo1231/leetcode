package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_271 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String length = numDigits(str);
            sb.append(length);
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int length = Integer.valueOf(s.substring(i, i + 3));
            i += 3;
            res.add(s.substring(i, i + length));
            i += length;
        }
        return res;
    }

    private String numDigits(String s) {
        int length = s.length();
        return String.format("%03d", length);
    }
}
