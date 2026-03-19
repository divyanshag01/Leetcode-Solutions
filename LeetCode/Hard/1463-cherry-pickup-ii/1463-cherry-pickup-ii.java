class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];
        for(int mat[][]:dp){
            for(int row[]:mat){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,0,n-1,grid,m,n,dp);
    }
    public int solve(int row,int c1,int c2,int grid[][],int m,int n,int dp[][][]){
        if(row>=m || c1<0 || c2<0 ||c1>=n || c2>=n){
            return (int)-1e9;
        }
        if(row==m-1){
            if(c1==c2) return grid[row][c1];
            else return grid[row][c1]+grid[row][c2];
        }
        if(dp[row][c1][c2]!=-1){
            return dp[row][c1][c2];
        }
        int max = 0;
        for(int i = -1;i<=1;i++){
            for(int j = -1;j<=1;j++){
                if(c1==c2){
                    max=Math.max(max,grid[row][c1]+solve(row+1,c1+i,c2+j,grid,m,n,dp));
                }else{
                    max=Math.max(max,grid[row][c1]+grid[row][c2]+solve(row+1,c1+i,c2+j,grid,m,n,dp));
                }
            }
        }
        return dp[row][c1][c2]=max; 
    }
}