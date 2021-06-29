package com.company;

import java.util.Arrays;
import java.util.Stack;

public class Histogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] input) {
        int ret = 0;
        int[] heights = new int[input.length + 1];
        for (int i = 0; i < input.length; i++) {
            heights[i] = input[i];
        }
        heights[input.length] = 0;
        Stack<Integer> monoStack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Before While: " + monoStack);
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                int h = heights[monoStack.pop()];
                int sidx = monoStack.isEmpty() ? -1 : monoStack.peek();
                ret = Math.max(ret, h * (i - sidx - 1));
                System.out.println("i = " + i + ", sidx = " + sidx + ", h = " + h + ", currRet = " + h * (i - sidx - 1) + ", ret = " + ret);
            }
            monoStack.push(i);
        }
        return ret;
    }
}
