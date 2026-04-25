class Tuple{
    int time;
    int row;
    int col;
    public Tuple(int time,int row,int col){
        this.time = time;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new Tuple(grid[0][0],0,0));
        int drow[] = {1,0,-1,0};
        int dcol[] = {0,1,0,-1};
        boolean visited[][] = new boolean[n][n];
        while(!pq.isEmpty()){
            Tuple tuple = pq.poll();
            int t = tuple.time;
            int row = tuple.row;
            int col = tuple.col;
            if(visited[row][col]) continue;
            visited[row][col]=true;
            if(row == n-1 && col==n-1) return t;
            for(int i = 0;i<4;i++){
                int nr = row+drow[i];
                int nc = col+dcol[i];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]){
                    int max = Math.max(t,grid[nr][nc]);
                    pq.offer(new Tuple(max,nr,nc));
                }
            }
        }
        return -1;
    }
}