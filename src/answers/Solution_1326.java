package answers;

public class Solution_1326 {
    public int minTaps(int n, int[] ranges) {
        int[][] array = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            array[i][0] = Math.max(0, i - ranges[i]);
            array[i][1] = i + ranges[i];
        }

        int pilot = 0, cnt = 0;
        boolean found = true;
        while (pilot < n && found) {
            int reach = pilot;
            found = false;
            for (int i = 0; i < n + 1; i++) {
                if (array[i][0] <= pilot && array[i][1] > pilot) {
                    reach = Math.max(reach, array[i][1]);
                    found = true;
                }
            }
            pilot = reach;
            cnt++;
        }

        return pilot >= n ? cnt : -1;
    }
}
