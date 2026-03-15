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
 class Tuple{
    TreeNode node;
    int x;
    int y;
    public Tuple(TreeNode node,int x,int y){
        this.node = node;
        this.x = x;
        this.y=y;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        TreeMap<Integer/*x*/,TreeMap<Integer/*y/level*/,PriorityQueue<Integer/*same x same y*/>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<Integer>());
            }
            map.get(x).get(y).offer(node.val);
            if(node.left!=null)q.offer(new Tuple(node.left,x-1,y+1));
            if(node.right!=null)q.offer(new Tuple(node.right,x+1,y+1));
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> col : map.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> nodes:col.values()){
                while(!nodes.isEmpty()){
                    temp.add(nodes.poll());
                }
            }
            list.add(temp);
        }
        return list;
    }
}