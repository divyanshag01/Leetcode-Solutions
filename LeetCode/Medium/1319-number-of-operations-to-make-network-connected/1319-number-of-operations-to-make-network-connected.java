class Solution {
    public int makeConnected(int n, int[][] connections) {
        int cables = connections.length;
        if(cables<n-1) return -1;
        boolean vis[] = new boolean[n];
        int cnt = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:connections){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                cnt++;
            }
        }
        return cnt-1;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[node] = true;
        for(int num:adj.get(node)){
            if(!vis[num]){
                dfs(num,adj,vis);
            }
        }
    }
}