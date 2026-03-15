/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        q.offer(root);
        // map.put(root,null);
        // int i = 1;
        //mapping parents;
        while(!q.isEmpty()){
            // int k = q.size();
            TreeNode node = q.poll();
            if(node.left!=null){
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                map.put(node.right,node);
                q.offer(node.right);
            }

        }
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        visited.put(target,true);
        q.offer(target);
        int crr = 0;
        while(!q.isEmpty()){
            int n = q.size();
            if(crr==k) break;
            crr++;
            for(int i = 0;i<n;i++){
                TreeNode current = q.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(map.get(current)!=null && visited.get(map.get(current))==null){
                    q.offer(map.get(current));
                    visited.put(map.get(current),true);
                }
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
}