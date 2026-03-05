/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        int last = 0;
        while(temp!=null){
            last = temp.val;
            temp = temp.next;
        }
        temp = node;
        while(temp!=null){
            temp.val = temp.next.val;
            if(temp.next.val==last){
                temp.next = null;
            }
            temp = temp.next;
        }
    }
}