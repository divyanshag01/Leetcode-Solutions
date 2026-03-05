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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode node = head;
        while(node!=null){
            sb.append(node.val);
            node=node.next;
        }
        StringBuilder rev = new StringBuilder(sb);
        // rev = sb;
        if(sb.toString().equals(rev.reverse().toString())){
            return true;
        }
        return false;
    }
}