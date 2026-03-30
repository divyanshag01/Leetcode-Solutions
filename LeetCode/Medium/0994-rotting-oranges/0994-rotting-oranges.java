class Solution {
    class Tuple{
        int x;
        int y;
        int t;
        public Tuple(int x,int y,int t){
            this.x = x;
            this.y = y;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Tuple> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        boolean vis[][] = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Tuple(i,j,0));
                    vis[i][j] = true;
                }
                if(grid[i][j]==1)fresh++;
            }
        }
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,-1,0,+1};
        int tm = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            int row = tuple.x;
            int col = tuple.y;
            int t = tuple.t;
            tm = Math.max(tm,t);
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    cnt++;
                    q.offer(new Tuple(nrow,ncol,t+1));
                    vis[nrow][ncol]=true;
                }
            }
        }
        if(cnt!=fresh) return -1;
        return tm;


    }
}