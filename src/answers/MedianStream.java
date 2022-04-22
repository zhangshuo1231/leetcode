package answers;

import java.util.PriorityQueue;

public class MedianStream {

    // Add any helper functions you may need here
    private void offer(int i, PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        if (min.isEmpty() || i >= min.peek()) {
            min.offer(i);
        }
        else {
            max.offer(i);
        }
        balance(min, max);
    }

    private void balance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        while (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
        while (max.size() - min.size() > 0) {
            min.offer(max.poll());
        }
    }

    int[] findMedian(int[] arr) {
        // Write your code here
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int cnt = 0;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            offer(arr[i], min, max);
            cnt++;
            if (cnt % 2 == 0) {
                res[i] = (min.peek() + max.peek()) / 2;
            }
            else {
                res[i] = min.peek();
            }
        }
        return res;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int[] arr_1 = {5, 15, 1, 3};
        int[] expected_1 = {5, 10, 5, 4};
        int[] output_1 = findMedian(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {2, 3, 4, 3, 4, 3};
        int[] output_2 = findMedian(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new MedianStream().run();
    }
}