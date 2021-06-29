package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Skyline {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyline(buildings));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int[] building : buildings) {
            map.putIfAbsent(building[0], new ArrayList<>());
            map.putIfAbsent(building[1], new ArrayList<>());
            map.get(building[0]).add(building);
            map.get(building[1]).add(building);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<List<Integer>> res = new ArrayList<>();
        for (int a : map.keySet()) {
            List<int[]> bs = map.get(a);
            for (int[] b : bs) {
                if (b[0] == a) {
                    maxHeap.offer(b); // enter new building
                } else {
                    maxHeap.remove(b); // exit building
                }
            }
            if (maxHeap.size() == 0) { // currently no building
                List<Integer> tmp = new ArrayList<>();
                tmp.add(a);
                tmp.add(0);
                res.add(tmp);
            } else {
                int maxHeight = maxHeap.peek()[2];
                if (res.size() == 0 || res.get(res.size() - 1).get(1) != maxHeight) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(a);
                    tmp.add(maxHeight);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
