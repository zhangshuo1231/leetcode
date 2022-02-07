package answers;

import java.util.*;

public class Solution_2003 {

    HashMap<Integer, List<Integer>> childrenLists = new HashMap<>();
    int[] distinctGenetic;
    int miss = 1;
    HashSet<Integer> set = new HashSet<>();

    public int[] smallestMissingValueSubtree(int[] parent, int[] nums) {
        int n = parent.length;
        distinctGenetic = nums;
        for(int i = 0; i < n; i++){
            childrenLists.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int idx = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                idx = i;
                break;
            }
        }
        if(idx == -1) return res;
        int curr = idx;

        int pre = -1; // 记录处理过的节点
        while (curr != -1) {
            List<Integer> list = childrenLists.get(curr);
            if(list != null){
                for(int j : childrenLists.get(curr)){
                    if(j == pre) {
                        continue; // 处理过的节点不能再遍历，不然会超时
                    }
                    dfs(j);
                }
            }
            set.add(distinctGenetic[curr]);
            while(set.contains(miss)){
                miss++;
            }
            res[curr] = miss;
            pre = curr; // 节点curr处理完了，更新pre和curr
            curr = parent[curr]; // 沿着1到root那条链往上
        }
        return res;
    }

    void dfs(int i){
        set.add(distinctGenetic[i]);
        List<Integer> list = childrenLists.get(i);
        if(list == null) return;
        for(int j : list){
            dfs(j);
        }
    }
}
