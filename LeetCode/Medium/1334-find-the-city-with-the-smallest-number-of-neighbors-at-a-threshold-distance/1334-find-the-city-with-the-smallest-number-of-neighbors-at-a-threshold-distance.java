class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] grid = new int[n][n];
        for(int edge[]:grid){
            Arrays.fill(edge,Integer.MAX_VALUE);
        }
        for(int num[]:edges){
            int u = num[0];
            int v = num[1];
            int wt = num[2];
            grid[u][v] = wt;
            grid[v][u] = wt;
        }
        int node = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            for(int u = 0;u<n;u++){
                for(int v = 0;v<n;v++){                    
                    if(u==v || u==i || v==i || grid[u][i]==Integer.MAX_VALUE || grid[i][v]==Integer.MAX_VALUE) continue;
                    if(grid[u][v]>grid[u][i]+grid[i][v]){
                        grid[u][v]=grid[u][i]+grid[i][v];
                    }
                }
            }
        }
        for(int u = 0;u<n;u++){
            int cnt = 0;
            for(int v = 0;v<n;v++){
                if(u!=v && grid[u][v]<=distanceThreshold) cnt++;
            }
            if(min>=cnt){
                min = cnt;
                node = u;
            }
        }
        return node;
    }
}