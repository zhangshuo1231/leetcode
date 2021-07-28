package answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RandomizedSet {
    ArrayList<Integer> nums;
    Set<Integer> numSet;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        numSet = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = numSet.contains(val);
        if (contain) return false;
        numSet.add(val);
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = numSet.contains(val);
        if (!contain ) return false;
        numSet.remove(val);
        nums.remove((Integer)val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}