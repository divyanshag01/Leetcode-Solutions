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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode knode = head;
        ListNode prevHead = head;
        while(temp!=null){
            knode = kthNode(temp,k);
            if(knode == null){
                prevHead.next = temp;
                break;
            }else{
                ListNode last = knode.next;
                knode.next =null;
                ListNode newHead = reverse(temp);
                if(temp == head){
                    head = newHead;
                }else{
                    prevHead.next = newHead;
                }
                prevHead = temp;
                temp.next = last;
                temp = temp.next;
            }
            
        }
        return head;
    }
    public ListNode kthNode(ListNode head,int k){
        ListNode temp = head;

        while(--k>0 && temp!=null){
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = head;
        while(temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}