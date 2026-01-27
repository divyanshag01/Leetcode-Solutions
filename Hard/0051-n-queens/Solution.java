class Solution {
   public void generate(int n,int i, boolean col[],boolean leftD[],boolean rightD[],List<List<String>> ans,char board[][]){
        if(i==n){
            List<String> temp = new ArrayList<>();
            for(int a = 0;a<n;a++){
                temp.add(new String(board[a]));
            }
            ans.add(temp);
            return;
        }
        for(int k = 0;k<n;k++){
            if(col[k]==true || leftD[i-k+n-1]==true || rightD[i+k]==true){
            continue;
            }
            col[k]=true;
            leftD[i-k+n-1]=true;
            rightD[i+k]=true;
            board[i][k]='Q';
            generate(n,i+1,col,leftD,rightD,ans,board);
            board[i][k]='.';
            col[k]=false;
            leftD[i-k+n-1]=false;
            rightD[i+k]=false;
        }
        
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        boolean col[] = new boolean[n];
        boolean leftD[] = new boolean[2*n-1];
        boolean rightD[] = new boolean[2*n-1];
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        generate(n,0,col,leftD,rightD,ans,board);
        return ans;
    }
}