package answers;

public class Solusion_322 {
    public static void main(String[] args) {
        System.out.println(coinChange_v2(new int[]{1}, 1));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        return helper(coins, amount, new int[amount+1]);
    }

    private static int helper(int[] coins, int rem, int[] count) {
        if(rem<0)
            return -1;
        if(rem==0)
            return 0;
        if(count[rem] != 0)
            return count[rem];

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res >= 0 && res < min)
                min = res + 1;
        }
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }

    public static int coinChange_v2(int[] coins, int amount) {
        int[] steps = new int[amount + 1];
        steps[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) {
                steps[coin] = 1;
            }
        }
        for (int i = 1; i < amount + 1; i++) {
            if (steps[i] != 0)
                continue;
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int departure = i - coin;
                if (departure > 0 && steps[departure] != 0 && steps[departure] != -1) {
                    min = Math.min(min, steps[departure] + 1);
                }
            }
            steps[i] = (min == Integer.MAX_VALUE? -1 : min);
        }
        return steps[amount];
    }
}
