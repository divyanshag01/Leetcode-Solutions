class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return generate(m,n,0,0,dp);
    }
    public int generate(int m,int n,int i,int j,int[][] dp){
        if(i==m-1 && j ==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int right = 0;
        int down = 0;
        right += generate(m,n,i,j+1,dp);
        down += generate(m,n,i+1,j,dp);
        return dp[i][j] = right+down;
    }
}