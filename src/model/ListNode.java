package model;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (next != null)
            sb.append(" -> " + next.toString());
        return sb.toString();
    }
}
