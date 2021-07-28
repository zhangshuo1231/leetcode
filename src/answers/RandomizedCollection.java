package answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, List<Integer>> book;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        book = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        boolean wasExisting = book.containsKey(val);
        book.putIfAbsent(val, new ArrayList<>());
        List<Integer> value = book.get(val);
        value.add(nums.size() - 1);
        return !wasExisting;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean wasExisting = book.containsKey(val);
        if (!wasExisting) {
            return false;
        }
        List<Integer> indexesInBook = book.get(val);
        int tobeRemoved = indexesInBook.remove(indexesInBook.size() - 1);
        if (book.get(val).size() == 0) {
            book.remove(val);
        }
        int currLastArrayIndex = nums.size() - 1;
        if (tobeRemoved != currLastArrayIndex) {
            int temp = nums.get(currLastArrayIndex);
            nums.set(tobeRemoved, temp);
            book.get(temp).remove((Integer) currLastArrayIndex);
            book.get(temp).add(tobeRemoved);
        }
        nums.remove(currLastArrayIndex);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
