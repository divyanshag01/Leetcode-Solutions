/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                flag = 1;
                break;
            }
        }
        if(flag==0) return null;
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        // slow = head;
        // int cnt = 0;
        // while(slow!=fast){
        //     slow=slow.next;
        //     cnt++;
        // }
        return slow;
    }
}