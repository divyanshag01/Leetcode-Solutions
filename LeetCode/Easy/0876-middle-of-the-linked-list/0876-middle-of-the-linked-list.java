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
    public ListNode middleNode(ListNode head) {
       int cnt = 0;
       ListNode temp = head;
       while(temp!=null){
        cnt++;
        temp=temp.next;
       }
       cnt/=2;
       int idx = 0;
        temp = head;
        while(temp!=null){
            //idx++;
            if(idx==cnt){
                return temp;
            }
            idx++;
            temp = temp.next;
        }
        return temp;
    }
}