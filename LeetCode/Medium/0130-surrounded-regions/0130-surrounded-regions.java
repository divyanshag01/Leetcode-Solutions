class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] board) {
       int m = board.length;
       int n = board[0].length;
       if(m==1 || n==1)return;
       Queue<Pair> q = new LinkedList<>();
       boolean vis[][] = new boolean[m][n];
       boolean safe[][] = new boolean[m][n];
       for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(i>0 && i<m-1 && j>0 && j<n-1) continue;
            if(board[i][j]=='O'){
                q.offer(new Pair(i,j));
                vis[i][j] = true;
                safe[i][j] = true;
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
            if(nrow>=0 &&nrow<m && ncol>=0 && ncol<n && !vis[nrow][ncol]){
                if(board[nrow][ncol]=='O'){
                    q.offer(new Pair(nrow,ncol));
                    vis[nrow][ncol]=true;
                    safe[nrow][ncol]=true;
                }
            }
        }
       }
       for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(!safe[i][j]){
                board[i][j]= 'X';
            }
        }
       } 
    //    return board
    }
}