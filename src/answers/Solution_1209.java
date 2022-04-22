package answers;

public class Solution_1209 {
    public String removeDuplicates(String s, int k) {
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            int lastIdx = sb.length() - 1;
            if (lastIdx > 0 && sb.charAt(lastIdx) == sb.charAt(lastIdx - 1)) {
                count[lastIdx] = count[lastIdx - 1] + 1;
            }
            else {
                count[lastIdx] = 1;
            }
            if (count[lastIdx] == k) {
                sb.delete(lastIdx - k + 1, lastIdx + 1);
            }
        }
        return sb.toString();
    }
}
