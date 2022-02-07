package answers;

public class Solution_424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            /*
            1 - 旧高频增加，window加宽，maxLength随之增加 - 更新
            2 - 新高频挑战成功，window加宽，maxLength随之增加 - 更新
            3 - 高频未变化，windows维持不变，start右移，同时更新start处相应的字母频率 - 其实不更新
            */
            int freq = ++count[s.charAt(end) - 'A'];
            boolean newCount = false;
            if (freq > maxCount) {
                maxCount = freq;
                newCount = true;
            }

            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            // maxLength = Math.max(maxLength, end - start + 1);

            if (newCount || start == 0) {
                maxLength = end - start + 1;
            }
        }
        return maxLength;
    }
}
