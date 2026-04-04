class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(); //adj list
        for(int i = 0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int num[]:prerequisites){
            list.get(num[1]).add(num[0]);
        }
        boolean vis[] = new boolean[numCourses];
        boolean pathVis[] = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,prerequisites,list)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,boolean vis[],boolean pathVis[],int grid[][],ArrayList<ArrayList<Integer>> list){
        vis[node] = true;
        pathVis[node] = true;
        for(int num:list.get(node)){
            if(vis[num] && pathVis[num]) return true;
            if(vis[num]==false){
                if(dfs(num,vis,pathVis,grid,list)) return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}