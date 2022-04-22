package answers;

import model.ListNode;

public class AddTwoLinkedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(7);
        first.next = new ListNode(5);
        first.next.next = new ListNode(9);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(6);

        ListNode second = new ListNode(8);
        second.next = new ListNode(4);

        System.out.println(reverse(addTwoListsReverse(reverse(first), reverse(second))));
        // System.out.println(reverse(first));
    }

    public static ListNode addTwoLists(ListNode first, ListNode second) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        dummyHead1.next = first;
        dummyHead2.next = second;
        padProcceddingZeros(dummyHead1, dummyHead2);
        ListNode dummyHeadResult = new ListNode(0);
        int carry = addTwoNodesHelper(dummyHead1.next, dummyHead2.next, dummyHeadResult);
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = dummyHeadResult.next;
            dummyHeadResult.next = node.next;
        }
        return dummyHeadResult.next;
    }

    // first 和 second 分别是两个List的真正头部，result本身是个真正的ListNode(0)
    // 返回是进位carry，每次recursion的时候result后面被插入以当前位为值的ListNode，result其本身返回上一层recursion
    // 最终的大返回，仍是carry和原先的result Node
    private static int addTwoNodesHelper(ListNode first, ListNode second, ListNode result) {
        if (first == null) {
            return 0;
        }
        int num = first.val + second.val + addTwoNodesHelper(first.next, second.next, result);
        ListNode node = new ListNode(num % 10);
        int carry = num / 10;
        node.next = result.next;
        result.next = node;
        return carry;
    }

    private static void padProcceddingZeros(ListNode first, ListNode second) {
        ListNode h1 = first, h2 = second;
        while (h1 != null && h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        if (h1 == null) {
            while (h2 != null) {
                ListNode node = new ListNode(0);
                node.next = first.next;
                first.next = node;
                h2 = h2.next;
            }
        }
        else {
            while (h1 != null) {
                ListNode node = new ListNode(0);
                node.next = second.next;
                second.next = node;
                h1 = h1.next;
            }
        }
    }

    static public ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static private ListNode addTwoListsReverse(ListNode first, ListNode second) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (first != null || second != null || carry != 0) {
            if (first != null) {
                carry += first.val;
                first = first.next;
            }
            if (second != null) {
                carry += second.val;
                second = second.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }
        return dummyHead.next;
    }
}
