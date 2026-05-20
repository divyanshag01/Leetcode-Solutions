class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[1]=1;
        dp[0]=1;
        return generate(n,dp);
    }
    public int generate(int n,int[] dp){
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1)return dp[n];
        return dp[n] = generate(n-1,dp)+generate(n-2,dp);
    }
}