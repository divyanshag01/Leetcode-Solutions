class Solution {
    public int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> num:connections){
            int u = num.get(0);
            int v = num.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int tin[] = new int[n]; //time of insertion
        int low[] = new int[n]; //lowest time of insertion
        List<List<Integer>> bridge = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,-1,adj,tin,low,vis,bridge);
            }
        }
        return bridge;
    }
    public void dfs(int node,int parent,List<List<Integer>> adj,int tin[],int low[],boolean vis[],List<List<Integer>> bridge){
        vis[node] = true;
        tin[node] = low[node] = timer++;
        for(int num:adj.get(node)){
            if(num==parent) continue;
            else if(!vis[num]){
                dfs(num,node,adj,tin,low,vis,bridge);
                low[node] = Math.min(low[node],low[num]);
                if(low[num]>tin[node]){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num);
                    temp.add(node);
                    bridge.add(temp);
                }
            }else{
                low[node] = Math.min(low[node],low[num]);
            }
        }


    }
}