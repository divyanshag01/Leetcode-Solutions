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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int cnt = 0;
        if(head.next==null && n == 1)return null;
        while(temp!=null){
            cnt++;
            temp = temp.next;
        }
        if(n==cnt) return head.next;
        n = cnt-n;
        temp = head;
        cnt = 0;
        while(temp!=null){
            cnt++;
            if(cnt==n){
                
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}