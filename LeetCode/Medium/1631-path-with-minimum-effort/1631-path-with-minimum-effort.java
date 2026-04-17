class Tuple{
    int dis;
    int row;
    int col;
    public Tuple(int dis,int row,int col){
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean visited[][] = new boolean[m][n];
        int drow[] = {1,0,-1,0}; 
        int dcol[] = {0,-1,0,1};
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.dis-b.dis); 
        pq.offer(new Tuple(0,0,0));
        visited[0][0] = true;
        while(!pq.isEmpty()){
            Tuple tuple = pq.poll();
            int dis = tuple.dis;
            int r = tuple.row;
            int c = tuple.col;
            visited[r][c] = true;
            if(r==m-1 && c==n-1) return dis; 
            for(int i = 0;i<4;i++){
                int nr = r+drow[i];
                int nc = c+dcol[i];
                if(nr>=0&&nc>=0 && nr<m && nc<n && !visited[nr][nc]){
                    int dif = Math.max(dis,Math.abs(heights[nr][nc]-heights[r][c]));
                    pq.offer(new Tuple(dif,nr,nc));
                }
            }
        }
        return 1;
    }
}