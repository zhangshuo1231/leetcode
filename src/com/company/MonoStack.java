package com.company;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

public class MonoStack {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextExceed(new int[]{5,3,1,2,4})));
    }

    public static int[] nextExceed(int[] input) {
        int[] result = new int[input.length];
        Arrays.fill(result, -1);
        Stack<Integer> monoStack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            while(!monoStack.isEmpty() && input[monoStack.peek()] < input[i]) {
                result[monoStack.peek()] = i - monoStack.pop();
            }
            monoStack.push(i);
        }
        return result;
    }
}
