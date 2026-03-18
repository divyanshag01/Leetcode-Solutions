class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        // if(m==1&&n==1 && obstacleGrid[m-1][n-1]==1)return 0; 
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return uniqueWays(m-1,n-1,obstacleGrid,dp);
    }
    public int uniqueWays(int m,int n,int obstacleGrid[][],int dp[][]){
        if(m<0||n<0) return 0;
        if(obstacleGrid[m][n]==1) return 0;
        if(m==0&&n==0){
            return 1;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        int l = uniqueWays(m-1,n,obstacleGrid,dp);
        int r = uniqueWays(m,n-1,obstacleGrid,dp);
        return dp[m][n]=l+r;
    }
}