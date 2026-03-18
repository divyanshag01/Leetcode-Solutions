class Solution {
    public int minPathSum(int[][] grid) {
        // int min = Integer.MIN_VAlUE;
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return minSum(m-1,n-1,grid,dp);
    }
    public int minSum(int m,int n,int[][] grid,int dp[][]){
        if(m==0&&n==0) return grid[m][n];
        if(m<0|| n<0) return (int)1e9;
        if(dp[m][n]!=-1) return dp[m][n]; 
        int l = minSum(m-1,n,grid,dp);
        int r = minSum(m,n-1,grid,dp);
        return dp[m][n]= grid[m][n]+Math.min(l,r);
    }
}