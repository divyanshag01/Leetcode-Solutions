class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            dp[n-1][i] = matrix[n-1][i];
        }
        for(int i = n-2;i>=0;i--){
            for(int j =n-1;j>=0;j--){
                dp[i][j]=matrix[i][j]+Math.min(dp[i+1][j],Math.min((j-1)>=0?dp[i+1][j-1]:(int)1e9,(j+1)<n?dp[i+1][j+1]:(int)1e9));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            min=Math.min(min,dp[0][i]);
        }
        return min;
    }
}