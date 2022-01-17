package answers;

public class Solution_308 {
    int[] arr;
    int[][] matrix;

    public Solution_308(int[][] matrix) {
        if(!(matrix == null || matrix.length == 0)) {
            this.matrix = matrix;
            int totalNums = matrix.length * matrix[0].length;
            int height = (int)Math.ceil(Math.log(totalNums)/Math.log(2)); // log n base 2
            int len = (int)Math.pow(2, height + 1) - 1;
            arr = new int[len];
            System.out.println("total nums: " + totalNums + ", height: " + height + ", len: " + len);
            build(0, totalNums - 1, 0);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(arr == null) return 0;
        int result = 0;
        for(int i = row1; i <= row2; i++) {
            int start = i * matrix[0].length + col1;
            int end = start + (col2-col1);
            result += query(start, end, 0, matrix.length*matrix[0].length-1, 0);
        }
        return result;
    }

    public void update(int row, int col, int val) {
        if(arr == null) return;
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        update(row * matrix[0].length + col, diff, 0, matrix.length * matrix[0].length - 1, 0);
    }

    // 0, 24, 0
    private int build(int start, int end, int index) {
        if(start == end) {
            arr[index] = getValue(start);
        } else {
            int mid = start + (end - start) / 2;
            arr[index] = build(start, mid, index * 2 + 1)
                    + build(mid+1, end, index * 2 + 2);
        }
        return arr[index];
    }

    // get value from matrix
    private int getValue(int n) {
        int i = n / matrix[0].length;
        int j = n % matrix[0].length;
        return matrix[i][j];
    }

    private void update(int target, int diff, int start, int end, int index) {
        arr[index] += diff;
        if(start == end) return;
        int mid = start + (end-start) / 2;
        if(target <= mid) update(target, diff, start, mid, 2*index+1);
        else update(target, diff, mid+1, end, 2*index+2);
    }

    private int query(int i, int j, int start, int end, int index) {
        if(i <= start && j >= end) return arr[index];
        if(i > end || j < start) return 0;
        int mid = start + (end-start) / 2;
        return query(i, j, start, mid, 2 * index + 1)
                + query(i, j, mid+1, end, 2 * index + 2);
    }
}
