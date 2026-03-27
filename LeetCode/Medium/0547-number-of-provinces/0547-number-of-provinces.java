class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length+1];
        int cnt = 0;
        for(int i = 1;i<vis.length;i++){
            if(!vis[i]){
                dfs(i,vis,isConnected);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int val,boolean vis[],int[][] isConnected){
        vis[val]=true;
        for(int i=1;i<=isConnected[val-1].length;i++){
            if(isConnected[val-1][i-1]==1 && vis[i]==false){
                dfs(i,vis,isConnected);
            }
        }
    }
}