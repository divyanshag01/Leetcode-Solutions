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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        right(root,0,list);
        return list;
    }
    public void right(TreeNode node,int level,List<Integer> list){
        if(node==null){
            return;
        }
        if(list.size()==level){
            list.add(node.val);
        }
        if(node.right!=null)right(node.right,level+1,list);
        if(node.left!=null)right(node.left,level+1,list);
    }
}