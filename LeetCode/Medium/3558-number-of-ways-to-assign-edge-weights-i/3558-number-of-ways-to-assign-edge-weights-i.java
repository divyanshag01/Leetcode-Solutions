class Solution {
    static int mod = 1000000007;
    public int assignEdgeWeights(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<edges.length+2;i++){
            adj.add(new ArrayList<>());
        }
        for(int num[]:edges){
            adj.get(num[0]).add(num[1]);
            adj.get(num[1]).add(num[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[edges.length+2];
        q.offer(1);
        int level = -1;
        vis[1] = true;
         while(!q.isEmpty()){
            int k = q.size();
            level++;
            while(k-->0){
            int n = q.remove();
            for(int num:adj.get(n)){
                if(vis[num]==false){
                    q.offer(num);
                    vis[num] = true;
                }
            }}
        }
        return power(2,level-1);
    }
    public int power(int base,int pow){
        int ans = 1;
        while(pow-->0){
            ans = (ans*base)%mod;
        }
        return (int)ans;
    }
}