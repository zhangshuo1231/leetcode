package answers;

public class Solution_974 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] reminders = new int[k];
        int curr = 0;
        reminders[0] = 1;
        for (int i : nums) {
            curr = (curr + i) % k;
            if (curr < 0) {
                curr = k + curr;
            }
            reminders[curr]++;
        }
        int res = 0;
        for (int i : reminders) {
            if (i > 1) {
                res += (i * (i - 1) / 2);
            }
        }
        return res;
    }
}
