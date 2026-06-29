class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode();
        ListNode s = small;
        ListNode big = new ListNode();
        ListNode b = big;
        while (head != null) {
            if (head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        b.next = null;
        s.next = big.next;
        return small.next;
    }
}