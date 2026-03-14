/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return list;
        q.offer(root);
        int flag = 0;
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<k;i++){
                if(q.peek().left!=null)q.add(q.peek().left);
                if(q.peek().right!=null)q.add(q.peek().right);
                temp.add(q.poll().val);
            }
            if(flag==1){
                Collections.reverse(temp);
                list.add(temp);
                flag=0;
            }else{
                list.add(temp);
                flag = 1;
            }
            
        }
        return list;
    }
}