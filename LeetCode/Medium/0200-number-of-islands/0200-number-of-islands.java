class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    cnt++;
                    // vis[i][j] = true;
                    dfs(m,n,i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
    public void dfs(int m,int n,int row,int col,boolean vis[][],char grid[][]){
        if(row<0||row>=m || col<0 || col>=n || vis[row][col]==true
         || grid[row][col]!='1' ) return;
        vis[row][col] = true;
        dfs(m,n,row+1,col,vis,grid);
        dfs(m,n,row-1,col,vis,grid);
        dfs(m,n,row,col+1,vis,grid);
        dfs(m,n,row,col-1,vis,grid);
    }
}