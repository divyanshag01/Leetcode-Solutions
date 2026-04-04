class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        // int n = graph[0].length;
        int color[] = new int[m];
        Arrays.fill(color,-1);
        for(int i = 0;i<m;i++){
            if(color[i]==-1){
                if(!dfs(i,color,graph,0))return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int color[],int graph[][],int colour){
        color[node] = colour;
        for(int num:graph[node]){
            if(color[num]!=-1){
                if(color[num]==color[node])return false;
            }else{
                if(!dfs(num,color,graph,colour==0?1:0)) return false;
            }
        }
        return true;
    }
}