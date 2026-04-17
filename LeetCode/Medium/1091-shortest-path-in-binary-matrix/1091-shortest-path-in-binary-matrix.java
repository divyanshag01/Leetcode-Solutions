class Pair{
    int row;
    int col;
    int dis;
    public Pair(int row,int col,int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        q.offer(new Pair(0,0,1));
        int dir[][] = {{-1,0},{-1,-1},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        visited[0][0]=true;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int r = pair.row;
            int c = pair.col;
            int d = pair.dis;
            if(r==n-1 && c == n-1) return d;
            for(int num[]:dir){
                int nr = r+num[0];
                int nc = c+num[1];
                if(nr>=0&&nc>=0&&nr<n&&nc<n && !visited[nr][nc] && grid[nr][nc]==0){
                    visited[nr][nc]=true;
                    q.offer(new Pair(nr,nc,d+1));
                }
            }
        }
        return -1;

    }
}