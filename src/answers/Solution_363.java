package answers;

import java.util.TreeSet;

public class Solution_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int numRow = matrix.length;
        if (numRow == 0)
            return 0;
        int numCol = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < numRow; i++){
            int[] array = new int[numCol];
            for (int j = i; j >= 0; j--){

                int val = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int count = 0; count < numCol; count++){
                    array[count] += matrix[j][count];
                    val += array[count];
                    Integer subres = set.ceiling(val - k);
                    if (null != subres){
                        res = Math.max(res, val - subres);
                    }
                    set.add(val);
                }

            }
        }
        return res;
    }
}