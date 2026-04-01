class Pair{
    int row;
    int col;
    int d;
    public Pair(int row,int col,int d){
        this.row = row;
        this.col  = col;
        this.d = d;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int row = pair.row;
            int col = pair.col;
            int d = pair.d;
            int drow[] = {-1,0,+1,0};
            int dcol[] = {0,-1,0,+1};
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 &&nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    q.offer(new Pair(nrow,ncol,d+1));
                    mat[nrow][ncol]=d+1;
                }
            }
        }
        return mat;
    }
}