class Solution {
    public int uniquePaths(int m, int n) {
        //int visited[][] = new int[m][n]; no need of visited arr as we can not revisit same cell;
        int dp[][] = new int[m][n];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return ways(m-1,n-1,dp);
    }
    public int ways(int m,int n,int dp[][]){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0||n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        // if(visited[m][n]==1){
        //     return 0;
        // }
        // visited[m][n]=1;
        int l= ways(m-1,n,dp);
        int r= ways(m,n-1,dp);
        // visited[m][n]=0;
        return dp[m][n]=l+r;
    }
}