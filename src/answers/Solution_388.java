package answers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_388 {
    public int lengthLongestPath(String input) {
        Deque<Integer> queue = new ArrayDeque<>();
        String[] arr = input.split("\n");
        int maxLen = 0;
        queue.push(0); //dummy null length
        System.out.println(Arrays.toString(arr));
        System.out.println();
        for (String s: arr) {
            int numOfTabs = s.lastIndexOf("\t") + 1;
            int level = numOfTabs + 1;
            /*
            The following part of code is the case that we want to consider when there are
            several subdirectories in a same level. We want to remove
            the path length of the directory or the file of same level
            that we added during previous step, and calculate
            the path length of current directory or file that we are currently looking at.
            */
            System.out.print("Curr queue size: " + queue.size() + "; Queue: " + queue + " , ");
            while (level < queue.size())
                queue.poll();
            System.out.print("Queue size reduced to " + queue.size() + "; ");
            int curLen = queue.peek() + s.length() - numOfTabs + 1;
            System.out.println("curr s: '" + s + "', currLen = " + curLen + ", level = " + level + ", numOfTabs = " + numOfTabs);
            System.out.println();
            queue.push(curLen);
            if (s.contains("."))
                maxLen = Math.max(maxLen, curLen - 1);
            // Only update the maxLen when a file is discovered,
            // And remove the "/" at the end of file
        }
        return maxLen;
    }
}
