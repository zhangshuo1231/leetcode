package answers;

class Solution_707 {
    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head;
    Node tail;
    int len;

    public Solution_707() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }

    public int get(int index) {
        if (index >= len) {
            return -1;
        }
        Node p = this.head;
        for (; index > 0; index--) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        Node n = new Node(val, null, this.head);
        if (this.head != null) {
            this.head.prev = n;
        }
        this.head = n;
        this.len++;
        if (this.len == 1) {
            this.tail = n;
        }
    }

    public void addAtTail(int val) {
        Node t = new Node(val, this.tail, null);
        if (this.tail != null) {
            this.tail.next = t;
        }
        this.tail = t;
        this.len++;
        if (this.len == 1) {
            this.head = t;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > len) {
            return;
        }
        Node i = new Node(val);
        Node p = this.head;
        for (; index > 0; index--) {
            p = p.next;
        }
        if (p == null) {
            addAtTail(val);
        }
        else {
            p.prev.next = i;
            i.prev = p.prev;
            i.next = p;
            p.prev = i;
        }
        this.len++;
    }

    public void deleteAtIndex(int index) {
        if (index >= len) {
            return;
        }
        Node p = this.head;
        for (; index > 0; index--) {
            p = p.next;
        }
        if (p.prev != null) {
            p.prev.next = p.next;
        }
        if (p.next != null) {
            p.next.prev = p.prev;
        }
        else {
            this.tail = p.prev;
        }
        this.len--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = this.head;
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }
}
