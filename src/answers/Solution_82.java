package answers;

import model.ListNode;

public class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        ListNode fakeTail = new ListNode(Integer.MAX_VALUE);
        fakeHead.next = head;
        ListNode radarPointer = head;
        while (radarPointer.next != null) {
            radarPointer = radarPointer.next;
        }
        radarPointer.next = fakeTail;
        radarPointer = fakeHead;
        ListNode ansHead = new ListNode(0);
        ListNode ansPointer = ansHead;

        while (radarPointer.next.next != null) {
            if (radarPointer.val != radarPointer.next.val && radarPointer.next.val != radarPointer.next.next.val) {
                ansPointer.next = radarPointer.next;
                ansPointer = ansPointer.next;
            }
            radarPointer = radarPointer.next;
        }
        ansPointer.next = null;
        return ansHead.next;
    }
}
