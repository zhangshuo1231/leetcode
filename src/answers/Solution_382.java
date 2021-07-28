package answers;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution_382 {
    ListNode head;
    Random random;

    public Solution_382(ListNode h) {
        head = h;
        random = new Random();
    }

    public int getRandom() {
        ListNode currNode = head;
        int currVal = currNode.val;
        for(int i = 1; currNode.next != null; i++){
            currNode = currNode.next;
            if (random.nextInt(i + 1) == i) currVal = currNode.val;
        }
        return currVal;
    }
}