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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int car = 0;
        int sum = 0;
       while(l1!=null || l2!=null ||car!=0){
        if(l1!=null){
            sum+= l1.val;
            l1 = l1.next;
        }
        if(l2!=null){
            sum+= l2.val;
            l2 = l2.next;
        }
        sum+=car;
        ListNode node = new ListNode(sum%10);
        car = sum/10;
        sum = 0;
        temp.next = node;
        temp = temp.next;
       }
       return head.next;
    }
}