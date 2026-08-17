class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]=='1'){
                    fill(grid,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void fill(char grid[][],int row,int col){
        int drow[] = {1,0,-1,0};
        int dcol[] = {0,-1,0,1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        grid[row][col]='.';
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i = 0;i<4;i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length){
                    if(grid[nr][nc]=='1'){
                        grid[nr][nc]='.';
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}