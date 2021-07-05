package answers;

import model.ListNode;

public class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode pointer = head.next.next;
        ListNode oddTail = head;
        ListNode evenTail = head.next;
        ListNode evenHead = head.next;
        int index = 3;
        while (pointer != null) {
            if (index % 2 == 1) {
                oddTail.next = pointer;
                oddTail = pointer;
            }
            else {
                evenTail.next = pointer;
                evenTail = pointer;
            }
            pointer = pointer.next;
            index++;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return head;
    }
}
