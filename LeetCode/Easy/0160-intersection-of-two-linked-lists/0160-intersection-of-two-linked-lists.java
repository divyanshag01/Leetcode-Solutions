/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0;
        int m = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;;
        while(tempA!= null){
            n++;
            tempA=tempA.next;
        }
        while(tempB!= null){
            m++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        while(n>m){
            n--;
            tempA=tempA.next;
        }while(m>n){
            m--;
            tempB=tempB.next;
        }
        while(tempA!=null && tempB!=null){
            if(tempA==tempB) return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
}