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
    public ListNode deleteMiddle(ListNode head) {
        int idx = 0;
        ListNode temp = head;
        while(temp!=null){
            idx++;
            temp = temp.next;
        }
        if(idx==1){
            temp = null;
            return temp;
        }
        temp = head;
        int i = 0;
        while(temp!=null){
            if(i+1==idx/2){
                if(temp.next==null||temp.next.next==null){
                    temp.next = null;
                }else{
                temp.next = temp.next.next;
            }}
            temp = temp.next;
            i++;
        }
        return head;
    }
}