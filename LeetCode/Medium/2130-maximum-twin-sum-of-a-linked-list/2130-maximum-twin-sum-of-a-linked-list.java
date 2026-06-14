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
    public int pairSum(ListNode head) {
        int i = 0;
        ListNode temp = head;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(temp!=null){
            map.put(i,temp.val);
            i++;
            temp = temp.next;
        }
        int max = Integer.MIN_VALUE;
        for(int j = 0;j<i;j++){
            if(map.containsKey(j)&& map.containsKey(i-1-j)){
                max = Math.max(max,map.get(j)+map.get(i-1-j));
            }
        }
        return max;
    }
}