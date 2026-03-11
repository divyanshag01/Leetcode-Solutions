/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        int cnt = 0;
        ListNode temp = head;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        k=k%cnt;
        if(k==0) return head;
        temp = head;
        while(k-->0){
            // ListNode last = temp;
            ListNode newHead = findLast(temp);
            newHead.next = temp;
            temp = newHead;
        }
        return temp;
    }
    public ListNode findLast(ListNode head){
        ListNode temp = head;
        while(temp.next != null && temp.next.next!=null){
            temp = temp.next;
        }
        ListNode last = temp.next;
        temp.next = null;
        return last;
    }
}