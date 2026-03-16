/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root== null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+" ");
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){ 
                sb.append(node.left.val+" ");
                q.offer(node.left);
            }
            else sb.append("n ");
            if(node.right!=null){
                sb.append(node.right.val+" ");
                q.offer(node.right);
            }
            else sb.append("n ");
            
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String nodes[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1;i<nodes.length;i++){
            TreeNode parent = q.poll();
            if(!nodes[i].equals("n")){
                parent.left=new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(parent.left);
            }else{
                parent.left=null;
            }
            if(!nodes[++i].equals("n")){
                parent.right=new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(parent.right);
            }else{
                parent.right=null;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));