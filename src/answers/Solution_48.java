package answers;

public class Solution_48 {
    public void rotate(int[][] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int[] t = nums[e];
            nums[e] = nums[s];
            nums[s] = t;
            s++;
            e--;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("i: " + i);
            for (int j = 0; j < nums.length; j++) {
                System.out.println("j: " + j);
                if (i < j) {
                    System.out.println(i + ", " + j);
                    int t = nums[j][i];
                    nums[j][i] = nums[i][j];
                    nums[i][j] = t;
                }
            }
        }
    }
}
