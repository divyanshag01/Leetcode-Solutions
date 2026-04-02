class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int total = 0;
        int cnt = 0;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i>0&&i<m-1 && j>0 && j<n-1){
                    if(grid[i][j]==1) total++;
                    continue;
                }
                if(grid[i][j]==1){
                    q.offer(new Pair(i,j));
                    cnt++;
                    total++;
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;
            int drow[] = {-1,0,+1,0};
            int dcol[] = {0,-1,0,+1};
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol));
                    vis[nrow][ncol]=true;
                    cnt++;
                }
            }
        }
        return total-cnt;
    }
}